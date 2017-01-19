package com.bigdata.hbr.controller;

import com.bigdata.hbr.entity.User;
import com.bigdata.hbr.exception.GenericException;
import com.bigdata.hbr.listener.UploadListener;
import com.bigdata.hbr.listener.UploadStatus;
import com.bigdata.hbr.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;




import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.util.Bytes;




/**
 * Created by percy on 2017/1/5.
 */
@RestController
@RequestMapping(value = "/test", produces = "application/json; charset=utf-8")
public class TestController {


    @Autowired
    private UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(String module) {
        return new ModelAndView(module);
    }


    @RequestMapping(value = "/doctorpatient", method = RequestMethod.GET)
    public ModelAndView doctorPatient() {
        return new ModelAndView("doctor-patient");
    }


    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public User getUser(String username) {
        try {
            System.out.println("getUser");
            return userService.getByUserName(username);
        } catch (GenericException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/getData")
    public void getDataFromHBase(String tableName){
        tableName = "hbr-data";
        String row = "patient.542.1483844111288";
        System.out.println("进入getData");
        try{
//            Configuration configuration = HBaseConfiguration.create();
//            HTable table = new HTable(configuration, tableName);
            Configuration configuration = HBaseConfiguration.create();
            HTable table = new HTable(configuration, tableName);
            Get get = new Get(Bytes.toBytes(row));
            Result result = table.get(get);
            System.out.println("result: " + Bytes.toString(result.value()));



        } catch (IOException e){
            e.printStackTrace();
        }


    }

    @RequestMapping("/uploadpage")
    public ModelAndView uploadPage() {
        return new ModelAndView("user-upload");
    }

    @RequestMapping(value = "/upload/{username}", method = RequestMethod.POST)
    public Object upload(HttpServletRequest request, HttpSession session, @PathVariable("username") String username) {

        try {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024*1024*100);
            UploadStatus uploadStatus = new UploadStatus();
            session.setAttribute("uploadStatus", uploadStatus);
            UploadListener listener = new UploadListener(uploadStatus);
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setProgressListener(listener);

            FileItemIterator iterator = upload.getItemIterator(request);

            while (iterator.hasNext()) {
                //FileItem item = (FileItem)iterator.next();
                DataInputStream in = new DataInputStream(iterator.next().openStream());
                String datas = "";
                int count20000 = 0;
                int countRowKey = 0;
                int t1, t2;
                while (in.available() > 0 &&
                        (t1 = in.readUnsignedByte()) >= 0 &&
                        (t2 = in.readUnsignedByte()) >= 0) {
                    int val = t2*256+t1;
//                    if (count20000 > 20000) {
//
//                    } else if (count20000 == 20000) {
//                        datas = datas + String.valueOf(val);
//                    } else {
//                        datas = datas + String.valueOf(val) + ",";
//                    }

                    System.out.println("val: "+val);
                }
            }


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



    @RequestMapping(value = "/uploadstatus")
    public Object upload(HttpSession session) {
        return session.getAttribute("uploadStatus");
    }



}

