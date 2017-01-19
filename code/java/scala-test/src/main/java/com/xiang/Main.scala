package com.xiang

import java.util.Properties

import kafka.serializer.StringDecoder
import net.sf.json.JSONObject
//import org.apache.hadoop.hbase.client.{HTable, Put}
//import org.apache.hadoop.hbase.util.Bytes
//import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by percy on 2017/1/6.
  */

object Main {

  def main(args: Array[String]): Unit = {



//    var masterUrl = "local[2]"
//    if (args.length > 0) {
//      masterUrl = args(0)
//    }
//
//    // Create a StreamingContext with the given master URL
//    val conf = new SparkConf().setMaster(masterUrl).setAppName("PageViewStream")
//    val ssc = new StreamingContext(conf, Seconds(5))
//
//    val topics = Set("hbr.patient")
//    //本地虚拟机ZK地址s
//    val brokers = "localhost:9092"
//    val kafkaParams = Map[String, String](
//      "metadata.broker.list" -> brokers,
//      "serializer.class" -> "kafka.serializer.StringDecoder"
//    )
//
//    val kafkaStream = KafkaUtils.createDirectStream[String, String,
//      StringDecoder, StringDecoder](ssc, kafkaParams, topics)
//
//    while(true) {
//
//      val events = kafkaStream.flatMap(line => {
//        val data = JSONObject.fromObject(line._2)
//        println(data)
//        Some(data)
//      })
//
//      println(events)
//
//      Thread.sleep(1000)
//    }


    val a = Array(1,2,3,5)
    var b = 0
    val c = Array(2,2,2)

    a.foreach(x => {

      c.foreach(y=> {
        b += y
      })
      //b = b + x
    })

    println(b)

  }

//  def tes(x: Int): Unit = {
//    println(x)
//  }

}
