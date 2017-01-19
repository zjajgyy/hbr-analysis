package com.xiang

import java.util.{Properties, Random, UUID}
import kafka.producer.KeyedMessage
import kafka.producer.Producer
import kafka.producer.ProducerConfig
import org.codehaus.jettison.json.JSONObject

/**
  * Created by hmh on 2016/12/25.
  */
object KafkaMessageGenerator {
  private val random = new Random()
  private var pointer = -1
  private val os_type = Array(
    "Android", "IPhone OS",
    "None", "Windows Phone")

  def click() : Double = {
    random.nextInt(10)
  }

  def getOsType() : String = {
    pointer = pointer + 1
    if(pointer >= os_type.length) {
      pointer = 0
      os_type(pointer)
    } else {
      os_type(pointer)
    }
  }

  def  generateString():String ={
   // val heartbeats =  Array(0.615, 0.62, 0.625, 0.63, 0.615, 0.615, 0.655, 0.64, 0.64, 0.62, 0.605, 0.605, 0.605, 0.605, 0.61, 0.59, 0.58, 0.59, 0.605)
    val heartbeats =  Array(2039, 2218, 2273, 2293, 2283, 2243, 2189, 2128, 2076, 2038, 2013, 1996, 1986, 1981, 1978, 1975, 1975, 1975, 1975, 1975)

    val sb = new StringBuilder
    for (x <-0 to 249) {
      val x =  (math.random * heartbeats.length).toInt;
      sb.append(heartbeats(x));
      sb.append(",");
    }
    sb.deleteCharAt(sb.length - 1);
    print("generateString为："+sb.toString())
    sb.toString();
  }

  def main(args: Array[String]): Unit = {
    val topic = "user_events"
    //本地虚拟机ZK地址
    // val brokers = "hadoop1:9092,hadoop2:9092,hadoop3:9092"
    val brokers = "localhost:9092"
    val props = new Properties()
    props.put("metadata.broker.list", brokers)
    props.put("serializer.class", "kafka.serializer.StringEncoder")

    val kafkaConfig = new ProducerConfig(props)
    val producer = new Producer[String, String](kafkaConfig)

    while(true) {
      // prepare event data
      val event = new JSONObject()
      event
        .put("uid", UUID.randomUUID())//随机生成用户id
        .put("event_time", System.currentTimeMillis.toString) //记录时间发生时间
        .put("os_type", getOsType) //设备类型
        .put("heartbeat", generateString()) //点击次数

      // produce event message
      producer.send(new KeyedMessage[String, String](topic, event.toString))
      println("Message sent: " + event)

      Thread.sleep(2000)
    }
  }


}
