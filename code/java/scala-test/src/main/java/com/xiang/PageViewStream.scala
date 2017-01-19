package com.xiang


import java.util.Scanner

import kafka.serializer.StringDecoder
import net.sf.json.JSONObject
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.{HTable, Put}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.classification.SVMModel

import scala.collection.mutable.ArrayBuffer

/**
  * Created by hmh on 2016/12/25.
  */
object PageViewStream {
  val down: Double = 0.1
  val up: Double = 2
  val time_interval: Double = 0.004
  //var patient_id:String=null
 // var time:String = null
  val conf=HBaseConfiguration.create()
  val maxTimestamp:Long = 9999999999999l

  def main(args: Array[String]): Unit = {



    ///Users/percy/Documents/course/project-training/big-data/hbr-analysis/code/model

  	var modelPath: String = ""
  	val scaner = new Scanner(System.in)
  	System.out.print("Model path: ")
  	if (scaner.hasNext()) {
  		modelPath = scaner.next()
  	}
    var masterUrl = "local[2]"
    if (args.length > 0) {
      masterUrl = args(0)
    }

    // Create a StreamingContext with the given master URL
    val conf = new SparkConf().setMaster(masterUrl).setAppName("PageViewStream")
    val ssc = new StreamingContext(conf, Seconds(5))
    val model = SVMModel.load(SparkContext.getOrCreate(conf), modelPath)
    // Kafka configurations
    //val topics = Set("PageViewStream")
    //val topics = Set("user_events")
    val topics = Set("hbr.patient")
    //本地虚拟机ZK地址
    //val brokers = "hadoop1:9092,hadoop2:9092,hadoop3:9092"
    val brokers = "localhost:9092"
    val kafkaParams = Map[String, String](
      "metadata.broker.list" -> brokers,
      "serializer.class" -> "kafka.serializer.StringEncoder")

    // Create a direct stream
    val kafkaStream = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](ssc, kafkaParams, topics)

    //获取event
    val events = kafkaStream.map(line => {
      val data = JSONObject.fromObject(line._2)
      data
    })
    val lines = events.map(x => (x.getString("patient"), x.getString("data"),x.getString("time")))
    //name = lines.map(x=>x._1).toString
    // time = lines.map(x=>x._3).toString

    val originData = new ArrayBuffer[Int]()
    lines.foreachRDD(rdd=>{
      rdd.foreach(x=>{
        val patient_id = x._1.toString
        val time = x._3.toString
        handleArr(patient_id,time,x._2.split(","), model)
      })
    })

    ssc.start()
    ssc.awaitTermination()

  }

  def handleArr(patient_id:String,time:String,arr : Array[String], model: SVMModel): Unit = {

    val originData = new ArrayBuffer[Int]()
    //val temp:Array[String] = msg.getString("heartbeat").split(",")
    arr.foreach( x => originData.append(x.toInt))
    val intervalArray = getInterval(originData)
    println("intervalArray大小：",intervalArray.size)
    val SD = calSD1AndSD2(intervalArray)


    val SD1,SD2 = calSD1AndSD2(intervalArray)
    val timestamp = maxTimestamp - time.toLong
    val rowID = "patient."+patient_id+"."+timestamp
    println("rowID:"+rowID+"----timestamp:"+timestamp)
    insertIntoHBase(rowID,originData.toString)
    val  mysqlConn = new MySqlConnection()
    val result: Double = model.predict(Vectors.dense(SD._1, SD._2))
    println(">>>>>> redict result: " + result)
    mysqlConn.saveToMySQL(SD._1,SD._2, result.toInt, patient_id)

    println("SD1--SD2:" + SD._1,SD._2)

  }
  def getInterval(array: ArrayBuffer[Int]):ArrayBuffer[Double]={
    /*
    *  第一次数据过滤
    */
    val dataLength1 = array.size-1
    println("dataLength1：",dataLength1)
    val dataBin = array
    println("intervalArray大小：",dataBin.size)
    println("dataBin：",array.toString)
    var id = new Array[Int](dataLength1+1)
    var dataBin1 = new Array[Long](dataLength1+1)
    var i = 0 //初始数据的下标
    var k = 0 //第一次过滤后的数据下标
    var j = 0 //计算平均值的下标
    var meanBegin: Long=0
    var meanEnd: Long=0
    var mean: Long=0
    val interval=5

    //计算前interval和后interval个点的平均值
    for (i <- 0 to (interval-1)){
      meanBegin = meanBegin + dataBin(i)
    }
    meanBegin = meanBegin/interval
    for (i <- (dataLength1-interval+1) to (dataLength1-1)){
      meanEnd = meanEnd + dataBin(i)
    }
    meanEnd = meanEnd/interval
    //判断第一个点是否为峰值点
    if (dataBin(0)>dataBin(1) & dataBin(0)>meanBegin){
      id(k) = 0
      dataBin1(k) = dataBin(i)
      k = k+1
    }

    //判断中间点是否为峰值点
    for (i <- 1 to (dataLength1-2)){
      //前interval个点
      if (i<=(interval/2) & dataBin(i)>dataBin(i+1) & dataBin(i)>dataBin(i-1) & dataBin(i)>meanBegin){
        id(k) = i
        dataBin1(k) = dataBin(i)
        k = k+1
      }

      //中间的点
      if (i>(interval/2+1) & i<(dataLength1-(interval/2))){
        if (dataBin(i)>dataBin(i+1) & dataBin(i)>dataBin(i-1)){
          for (j <- (i-interval/2) to (i+interval/2-1)){
            mean = mean + dataBin(j)
          }
          mean = mean/interval
          if (dataBin(i)>mean){
            id(k) = i
            dataBin1(k) = dataBin(i)
            k = k+1
          }
        }
      }

      //后interval个点
      if (i>=dataLength1-(interval/2)){
        if (dataBin(i)>dataBin(i+1) & dataBin(i)>dataBin(i-1) & dataBin(i)>meanEnd){
          id(k) = i
          dataBin1(k) = dataBin(i)
          k = k+1
        }
      }
    }

    //判断最后一个点是否为峰值点
    if (dataBin(dataLength1-1)>dataBin(dataLength1-2) & dataBin(dataLength1-1)>meanEnd){
      id(k) = i
      dataBin1(k) = dataBin(i)
      k = k+1
    }

    println("第一次过滤完的个数："+(k-1))


    /*
    *  第二次数据过滤
    */
    val dataLength2 = k-1 //第一次过滤后的数据个数
    var id2 = new Array[Int](dataLength2+1)
    i = 0 //id数组和dataBin1数组的数据下标
    k = 0 //第二次过滤后的数据下标
    var ix = 0 //i对应的id中的相应数据
    //计算前interval和后interval个点的平均值
    for (i <- 0 to (interval-1)){
      meanBegin = meanBegin + dataBin1(i)
    }
    meanBegin = meanBegin/interval
    for (i <- (dataLength2-interval) to (dataLength2-1)){
      meanEnd = meanEnd + dataBin1(i)
    }
    meanEnd = meanEnd/interval

    //判断第一个点是否为峰值点
    if (dataBin1(0)>dataBin1(1) & dataBin1(0)>meanBegin){
      id2(k) = 0
      //println(k, "  ", i, " ", ix)
      k = k+1
    }
    //判断中间点是否为峰值点
    for (i <- 1 to (dataLength2-2)){
      //前interval个点
      ix = id(i)
      if (i<=(interval/2) & dataBin1(i)>dataBin1(i+1) & dataBin1(i)>dataBin1(i-1) & dataBin1(i)>meanBegin){
        id2(k) = ix
        //println(k, "  ", i, " ", ix)
        k = k+1
      }

      //中间的点
      if (i>(interval/2) & i<(dataLength2-(interval/2)-1)){
        if (dataBin1(i)>dataBin1(i+1) & dataBin1(i)>dataBin1(i-1)){
          for (j <- (i-interval/2) to (i+interval/2-1)){
            mean = mean + dataBin1(j)
          }
          mean = mean/interval
          if (dataBin1(i)>mean){
            id2(k) = ix
            //println(k, "  ", i, " ", ix)
            k = k+1
          }
        }
      }

      //后interval个点
      if (i>=dataLength2-(interval/2)-1){
        if (dataBin1(i)>dataBin1(i+1) & dataBin1(i)>dataBin1(i-1) & dataBin1(i)>meanEnd){
          id2(k) = ix
          //println(k, "  ", i, " ", ix)
          k = k+1
        }
      }
    }


    //判断最后一个点是否为峰值点
    if (dataBin1(dataLength2-1)>dataBin1(dataLength2-2) & dataBin1(dataLength2-1)>meanEnd){
      id2(k) = ix
      println(k, "  ", i, " ", ix)
      k = k+1
    }

    println("第二次过滤完:"+(k-1))
    for (elem <- id2) {
      print(elem + " , ")
    }
    println("id2:",id2)

    // for (i <- 1 to k-1){
    //   println(id2(i))
    // }
    /*
    *  计算时间间隔
    */
    val timeLength = k-1
    var time = new ArrayBuffer[Double]()
    var rr: Double=0
    k = 0
    for (i <- 0 to (timeLength-2)){
      rr = (id2(i+1)-id2(i))*time_interval
      if (rr<=up & rr>=down){
        time.append(rr)
        k = k+1
      }
    }
    println("时间间隔数据长度:"+(k-1))
    for (elem <- time) {
      print(time + " , ")
    }
    return time
  }


  def calSD1AndSD2(interArrayBuffer: ArrayBuffer[Double]):(Double,Double)={
    val len =  interArrayBuffer.size
    //println("interArray:",interArrayBuffer(5))
    val interArray = interArrayBuffer.toArray
    //x,y数组
    var arrayX = new Array[Double](len)
    var arrayY = new Array[Double](len)
    val arrayX_Y = new Array[Double](len)
    val arrayXY = new Array[Double](len)
    arrayX = interArray.dropRight(1)
    arrayY = interArray.drop(1)
    for (i <- 0 to (len-2)){
      arrayX_Y(i) = arrayX(i) - arrayY(i)
      arrayXY(i) = arrayX(i) + arrayY(i)
    }
    println("array len:",arrayX_Y.length)
    val SD1 = calculateSD(arrayX_Y)
    val SD2 = calculateSD(arrayXY)

    println("SD1:",SD1)
    println("SD2:",SD2)
    return(SD1,SD2)
  }

  def insertIntoHBase(rowID:String,data:String)
  {
    val table = new HTable(conf, "hbr-data")
    val put = new Put(Bytes.toBytes(rowID))
    put.add(Bytes.toBytes("cf"),Bytes.toBytes("data"),Bytes.toBytes(data))
    table.put(put)
    table.close
    println("insert into successfully")

  }

  def calculateSD(array:Array[Double]):Double={
    //var array = array
    //通过map和reduce方法得到(x-y)的和,(x-y)的平方和
    val result = array.map(a => (1,a,a*a)).reduce((a,b)=>(a._1 + b._1,a._2+b._2,a._3+b._3))
    val SD = Math.sqrt((result._3/result._1-result._2*result._2/result._1/result._1)/2)
    return SD
  }
}

