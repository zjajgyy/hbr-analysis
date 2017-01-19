package com.lpxiang.hbr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by percy on 2017/1/3.
 */
public class KafkaConsumer implements Runnable {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String topic;

    public KafkaConsumer(String topic) {
        this.topic = topic;
    }

    @Override
    public void run() {
        ConsumerConnector consumer = this.createConsumer();
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, 1); // 一次从主题中获取一个数据

        Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = messageStreams.get(topic).get(0);// 获取每次接收到的这个数据
        ConsumerIterator<byte[], byte[]> iterator = stream.iterator();
        while(iterator.hasNext()){
            String message = new String(iterator.next().message());
            System.out.println("Received msg: " + message);
        }

    }

    public ConsumerConnector createConsumer() {
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream(System.getProperty("user.dir") + File.separator + "conf" +
                    File.separator + "kafka-consumer.properties");
            properties.load(in);
            in.close();
            return Consumer.createJavaConsumerConnector(new ConsumerConfig(properties));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String []args) {
        new Thread(new KafkaConsumer("hbr.patient")).run();
    }

}
