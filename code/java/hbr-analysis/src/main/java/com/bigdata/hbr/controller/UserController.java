package com.bigdata.hbr.controller;

import com.bigdata.hbr.entity.User;
import com.bigdata.hbr.exception.GenericException;
import com.bigdata.hbr.listener.UploadListener;
import com.bigdata.hbr.listener.UploadStatus;

import com.bigdata.hbr.plugin.HistoryDataMultiProcess;
import com.bigdata.hbr.service.UserService;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by percy on 2017/1/7.
 */
@RestController
@RequestMapping(value = "/user", produces = "application/json; charset=utf-8")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login.do")
    public Object login(String username,String password, HttpSession session) {
        User user;
        Map<String, Object> res = new HashMap<>();

        try {
            user = userService.getByUserName(username);
            if(user != null && user.getPassword().equals(password)) {
                res.put("code", 200);
                session.setAttribute("username", user.getUsername());
                session.setAttribute("role", user.getRole());
                session.setAttribute("name", user.getName());

                switch (user.getRole()){
                    case "common":
                        res.put("target", "/hbr/home/?location=user");
                        break;
                    case "doctor":
                        res.put("target", "/hbr/home/?location=doctor");
                        break;
                    case "admin":
                        res.put("target", "/hbr/home/?location=admin");
                        break;
                }
            } else {
                res.put("code", -1);
                res.put("msg", "用户名或者密码错误");
            }
        } catch (GenericException e) {
            e.printStackTrace();
        }

        return res;
    }

    @RequestMapping("/logout")
    public void logout(HttpServletResponse response, HttpSession session) {

        session.removeAttribute("username");
        session.removeAttribute("name");
        session.removeAttribute("role");

        try {
            response.sendRedirect("/hbr/home/?location=login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping(value = "/upload/{username}", method = RequestMethod.POST)
    public Object upload(HttpServletRequest request, HttpSession session, @PathVariable("username") String username) {

        try {
            //String username = "testUserName1";
            String tableName = "hbr-data";
            String columnFamily = "cf";
            String column = "data";
            String row = "";
            String datas = ""; //用于对数据分片
            int countRowKey = 0; //用于对rowkey进行赋值
            Configuration configuration = HBaseConfiguration.create();
            configuration.set("hbase.zookeeper.property.clientPort","2181");
            Connection conn = ConnectionFactory.createConnection(configuration);
            Table table = conn.getTable(TableName.valueOf(tableName));


            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024*1024*100);
            UploadStatus uploadStatus = new UploadStatus();
            session.setAttribute("uploadStatus", uploadStatus);
            UploadListener listener = new UploadListener(uploadStatus);
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setProgressListener(listener);

            FileItemIterator iterator = upload.getItemIterator(request);

            int count20000 = 0;
            while (iterator.hasNext()) {
                //FileItem item = (FileItem)iterator.next();
                DataInputStream in = new DataInputStream(iterator.next().openStream());

                count20000 = 0;

                System.out.println(">>>>>>> Start insert...");

                int t1, t2;
                while (in.available() > 0 &&
                        (t1 = in.readUnsignedByte()) >= 0 &&
                        (t2 = in.readUnsignedByte()) >= 0) {
                    int val = t2 * 256 + t1;

                    //System.out.println(">>>>>>> count: "+count20000 + ", val: " + val);

                    if (count20000 == 0){
                        datas = String.valueOf(val);
                        count20000 = count20000 + 1;
                    } else if (count20000 == 20000) {
                        countRowKey = countRowKey + 1;
                        row = username + countRowKey;
                        Put put = new Put(Bytes.toBytes(row));
                        put.add(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(datas));
                        table.put(put);
                        count20000 = 0;
                        datas = "";

                        System.out.println(">>>>>>> Add 20000 records...");

                    } else {
                        datas = datas + "," + String.valueOf(val);
                        count20000 = count20000 + 1;
                    }
                }
            }
            countRowKey ++;
            row = username + countRowKey;
            Put p1 = new Put(Bytes.toBytes(row));
            p1.add(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(datas));
            table.put(p1);
            System.out.println(">>>>>>> Last count: " + count20000);
            System.out.println(">>>>>>> Finished add history data to hbase.");

            session.setAttribute("startCalculateTime", new Date().getTime());
            new Thread(new HistoryDataMultiProcess(username)).start();

//                if(ImgUtil.imageScale(file.getInputStream(), imgRoot+fileName, suffix.substring(1), 768, 1024)) {
//
//                    out.print(ErrorCode.getJson(ErrorCode.CODE_OK, fileName));
//                } else {
//
//                    out.print(ErrorCode.getJson(ErrorCode.IMG_SCALE_ERROR, "上传头像失败，压缩图片错误！"));
//                }

        } catch (IllegalStateException e1) {
            // TODO Auto-generated catch block
            //e1.printStackTrace();
            //out.print("{"+"\"error\":\""+e1.getMessage()+"\"}");
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            //e1.printStackTrace();
            //out.print("{"+"\"error\":\""+e1.getMessage()+"\"}");
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return "OK";
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public User getUser(String username) {
        try {
            return userService.getByUserName(username);
        } catch (GenericException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public int addUser(String username,String password,String name,String gender) {
        return userService.addUser(username,password,name,gender);
    }

    @RequestMapping(value = "/adddoctor", method = RequestMethod.POST)
    public int addDoctor(String username,String password,String name,String gender){
        return userService.addDoctor(username,password,name,gender);
    }

    @RequestMapping(value = "/deletedoctor", method = RequestMethod.DELETE)
    public int deleteDoctor(String username){
        return userService.deleteDoctor(username);
    }

    @RequestMapping(value = "/getdoctors", method = RequestMethod.POST)
    public Object getDoctors(String doctorName) {
        try {
            Map<String, Object> res = new HashMap();
            res.put("data", userService.getDoctors(doctorName));
            res.put("code", 200);
            return res;
        } catch (GenericException e) {
            //e.printStackTrace();
            return e.getMessage();
        }
    }

}