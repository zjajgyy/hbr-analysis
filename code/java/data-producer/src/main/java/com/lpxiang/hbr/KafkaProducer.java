package com.lpxiang.hbr;

import kafka.producer.KeyedMessage;
import kafka.javaapi.producer.Producer;
import kafka.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by percy on 2016/12/25.
 */
public class KafkaProducer implements Runnable {


    //Logger logger = LoggerFactory.getLogger(this.getClass());

    private String topic;
    private String workDir;
    private String patientFlag;
    private String filePath;
    private Integer itemNum = 500;  // 每一次发送的心跳数

    public KafkaProducer(String patientFlag, String filePath){
        super();
        this.topic = "hbr.patient";
        this.patientFlag = patientFlag;
        this.filePath = filePath;

        workDir = System.getProperty("user.dir");
        System.out.println(">>> Current dir: " + workDir);
        //classPath = ClassLoader.getSystemResource("").getPath();
        //System.out.println("Classpath: " + classPath);
    }


    @Override
    public void run() {
        Producer producer = this.createProducer();

        if (producer == null) {
            System.err.println(">>> Create producer error.");
            return;
        }

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(new File(filePath)));

            //FileOutputStream tout = new FileOutputStream("/Users/percy/Desktop/1.out.txt");
            //FileWriter writer = new FileWriter("/Users/percy/Desktop/1.out.txt");
            //PrintWriter writer = new PrintWriter("/Users/percy/Desktop/1.out.txt");

            int t1 = 0, t2 = 0, dataNum = 0;

            while(true){
                StringBuilder data = new StringBuilder();
                dataNum = 0;
                while (dis.available() > 0 &&
                        (t1 = dis.readUnsignedByte()) >= 0 &&
                        (t2 = dis.readUnsignedByte()) >= 0 ) {
                    Integer val = t2 * 256 + t1;
                    data.append(val).append(",");
                    if (dataNum ++ >= this.itemNum) {
                        break;
                    }

                }


                if (dataNum == 0) {
                    break;
                }

                String msg = String.format("{\"patient\": \"%s\", \"time\": %s, \"data\": \"%s\"}",
                        this.patientFlag, new Date().getTime(), data.toString());
                producer.send(new KeyedMessage<Integer, String>(topic, msg));
                System.out.println(">>> put msg: \n" + msg);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            dis.close();

            System.out.println(">>> All data has been translated.");

        } catch (FileNotFoundException e) {
            System.out.println(">>> File not exist, path: "+filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Producer createProducer() {
        Properties properties = new Properties();
//        properties.put("zookeeper.connect", "192.168.1.110:2181,192.168.1.111:2181,192.168.1.112:2181");//声明zk
//        properties.put("serializer.class", StringEncoder.class.getName());
//        properties.put("metadata.broker.list", "192.168.1.110:9092,192.168.1.111:9093,192.168.1.112:9094");// 声明kafka broker

        try {

            FileInputStream in = new FileInputStream(workDir + File.separator + "conf" +
                                File.separator + "kafka-producer.properties");
            properties.load(in);
            this.itemNum = Integer.valueOf(properties.getProperty("itemNum"));
            in.close();
            return new Producer<Integer, String>(new ProducerConfig(properties));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {

        String patientFlag = null;
        String filePath = "/Users/percy/Desktop/1.txt";
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the patient flag: ");
        if (sc.hasNext()) {
            patientFlag = sc.next();
        }

        System.out.print("Input the heart bit binary data file path: ");
        if (sc.hasNext()) {
            filePath = sc.next();
        }

        new Thread(new KafkaProducer(patientFlag, filePath)).start();

//        System.out.println(String.format("The long v: %s", 509832l));

    }
}
