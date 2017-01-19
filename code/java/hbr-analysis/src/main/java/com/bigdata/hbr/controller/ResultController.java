package com.bigdata.hbr.controller;

import com.bigdata.hbr.entity.PatientResult;
import com.bigdata.hbr.entity.UserResult;
import com.bigdata.hbr.service.PatientService;
import com.bigdata.hbr.service.ResultService;
import net.sf.json.JSONArray;
import org.apache.commons.collections.map.HashedMap;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.Oneway;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Zero on 2017/1/8.
 */
@RestController
@RequestMapping(value = "/result", produces = "application/json; charset=utf-8")
public class ResultController {

    @Autowired
    private ResultService resultService;


    @RequestMapping(value = "/getpatientresultfrommysql", method = RequestMethod.GET)
    public PatientResult getPatientResultFromMysql(int patientid) {

        return resultService.getPatientResult(patientid);

    }

    @RequestMapping(value = "/getpatientfromhbase", method = RequestMethod.GET)
    public Object getPatientResultFromHbase(int patientId, long timestamp) {

        //String username = "patient";
        String tableName = "hbr-data";
        String columnFamily = "cf";
        String column = "data";
        String row = "";
        long max =  9999999999999L;
        String filterRowKey = "patient."+String.valueOf(patientId)+".";
        //ArrayList<Object> array = new ArrayList<Object>();
        JSONArray array = new JSONArray();
        try {
            Configuration configuration = HBaseConfiguration.create();
            Connection conn = ConnectionFactory.createConnection(configuration);

            Table table = conn.getTable(TableName.valueOf(tableName));
            PrefixFilter prefixFilter = new PrefixFilter(Bytes.toBytes(filterRowKey));

            FilterList filterList = new FilterList();

            RowFilter filter1 = new RowFilter(CompareFilter.CompareOp.LESS, new BinaryComparator(Bytes.toBytes(filterRowKey+String.valueOf(max-timestamp))));
            filterList.addFilter(prefixFilter);
            filterList.addFilter(filter1);

            Scan s = new Scan();
            s.setFilter(filterList);
            s.addColumn(columnFamily.getBytes(), column.getBytes());
            ResultScanner scanner = table.getScanner(s);
            for (Result r: scanner) {
                Map<String, Object> map = new HashedMap();
                map.put("patient", Bytes.toString(r.getRow()));
                map.put("value", Bytes.toString(r.value()));
                map.put("timestamp", r.raw()[0].getTimestamp());
                array.add(map);
                map.clear();
            }
            //System.out.println(Bytes.toString(result.value()));

            return array;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    @RequestMapping(value = "/getuserresult", method = RequestMethod.GET)
    public   List<UserResult> getUserResult(String username, HttpSession session){
        Long timestamp = (Long)session.getAttribute("startCalculateTime");
        System.out.println(">>>>>>>> timestamp: " + new Date(timestamp));
        return resultService.getUserResult(username, timestamp);
    }
}



