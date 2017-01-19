package com.bigdata.hbr.plugin

import org.apache.hadoop.hbase.client.{ConnectionFactory, Scan}
import org.apache.hadoop.hbase.filter.PrefixFilter
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.spark.SparkConf

import scala.collection.JavaConversions._
import org.apache.spark.mllib.classification.SVMModel
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import java.sql.{Connection, DriverManager}
import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.mllib.linalg.Vectors

object TestCommonScala {
  val conf=HBaseConfiguration.create()
//Connection 的创建是个重量级的工作，线程安全，是操作hbase的入口
val conn=ConnectionFactory.createConnection(conf)
//从Connection获得 Admin 对象(相当于以前的 HAdmin)
val admin=conn.getAdmin
val userTable=TableName.valueOf("hbr-data")
val table=conn.getTable(userTable)

def main(args: Array[String]) {
if(admin.tableExists(userTable)){
  val user = args(0)
  getUserData(user)
}else{
  println("Table not exists!")
  println("Please create table first!")
}
  }

def getUserData(userName:String)
{
  //从Hbase根据prefixFilter查询指定用户数据
  val prefixFilter = new PrefixFilter(Bytes.toBytes(userName));
  val s = new Scan()
  s.setFilter(prefixFilter)
  s.addColumn("cf".getBytes,"data".getBytes)
  val scanner = table.getScanner(s)
  var data:String=""
  try{
  for(r <- scanner){
    data=data+Bytes.toString(r.getValue("cf".getBytes,"data".getBytes))+","
  }
  val dataString:Array[String] = data.split(",")
  val length = dataString.length
  val dataInt = new Array[Int](length)
  for(i <- 0 to length-1)
  {
    dataInt(i) = dataString(i).toInt
  }
  //计算心跳间隔
   var index1 = new Array[Int](length)
   var dataFirst = new Array[Int](length)
   var m = 0
   //第一遍过滤峰值，取间隔是1000计算滑动平均
   for(i <- 1 to dataInt.length-2)
   {
     if(i<500)
      {
        var avg:Long =0
        var sum:Long = 0
        for(j <- 0 to 999)
        {
          sum = sum + dataInt(j)
        }
        avg = sum/1000
        
        if(dataInt(i)>dataInt(i-1) & dataInt(i)>dataInt(i+1) & dataInt(i) > avg)
        {
          index1(m)=i
          dataFirst(m) = dataInt(i)
          m = m + 1
        }
      }
     else if(i>dataInt.length-501)
      {
        var avg:Long =0
        var sum:Long = 0
        for(j <- (dataInt.length-1001) to dataInt.length-2)
        {
          sum = sum + dataInt(j)
        }
        avg = sum/1000
        if(dataInt(i)>dataInt(i-1) & dataInt(i)>dataInt(i+1) & dataInt(i) > avg)
        {
          index1(m)=i
          dataFirst(m) = dataInt(i)
          m = m+1
        }
      }
     
      else
      {
        var avg:Long =0
        var sum:Long = 0
        for(j <- (i-500) to (i+500))
        {
          sum = sum + dataInt(j)
        }
        avg = sum/1000
        if(dataInt(i)>dataInt(i-1) & dataInt(i)>dataInt(i+1) & dataInt(i) > avg)
        {
          index1(m)=i
          dataFirst(m) = dataInt(i)
          m = m+1
        }
      }
   }
   
   //第二遍过滤峰值，取间隔是400作为滑动平均
   var index2 = new Array[Int](m)
   var dataSecond = new Array[Int](m)
   var n = 0    
   for(i <- 1 to m-2)
   {
     if(i<200)
      {
        var avg:Long =0
        var sum:Long = 0
        for(j <- 0 to 399)
        {
          sum = sum + dataFirst(j)
        }
        avg = sum/400
        
        if(dataFirst(i)>dataFirst(i-1) & dataFirst(i)>dataFirst(i+1) & dataFirst(i) > avg)
        {
          index2(n)=index1(i)
          dataSecond(n) = dataFirst(i)
          n = n+1
        }
      }
      else if(i>dataFirst.length-201)
      {
        var avg:Long =0
        var sum:Long = 0
        for(j <- (dataFirst.length-398) to dataFirst.length-2)
        {
          sum = sum + dataFirst(j)
        }
        avg = sum/400
        if(dataFirst(i)>dataFirst(i-1) & dataFirst(i)>dataFirst(i+1) & dataFirst(i) > avg)
        {
          index2(n)=index1(i)
          dataSecond(n) = dataFirst(i)
          n = n+1
        }
      }
      
      else
      {
        var avg:Long =0
        var sum:Long = 0
        for(j <- (i-200) to (i+200))
        {
          sum = sum + dataFirst(j)
        }
        avg = sum/400
        if(dataFirst(i)>dataFirst(i-1) & dataFirst(i)>dataFirst(i+1) & dataFirst(i) > avg)
        {
          index2(n)=index1(i)
          dataSecond(n) = dataFirst(i)
          n = n+1
        }
      }
   }
   
   //计算第二次峰值之间的间隔并过滤掉脏数据
   var interval = new Array[Double](n)
   var final_interval = new Array[Double](n)
   var p:Int= 0
   for(i <- 0 to n-2)
  {
     interval(i) = (index2(i+1)-index2(i))*0.004
     if(interval(i)>=0.3 & interval(i)<2)
     {
       final_interval(p)=interval(i)
       p= p+1
     }
   }
   
   
   //使用间隔，使用map reduce计算sd1 sd2
    compute(p,final_interval,userName)
    
   
   
  
}finally {
  //确保scanner关闭
  scanner.close()
}

}
def compute(p:Int,final_interval:Array[Double],userName:String)
{
   var x = new Array[Double](p-1)
   var y = new Array[Double](p-1)
   var xAddy = new Array[Double](p-1)
   var xSuby = new Array[Double](p-1)
   for(j<- 0 to p-2)
   {
     x(j) = final_interval(j)
     y(j) = final_interval(j+1)
     xAddy(j) = x(j)+y(j)
     xSuby(j) = x(j)-y(j)
   }
   
   var tempSD1 = xSuby.map(a=>(1,a,a*a)).reduce((a,b)=>(a._1+b._1,a._2+b._2,a._3+b._3))
   var tempSD2 = xAddy.map(a=>(1,a,a*a)).reduce((a,b)=>(a._1+b._1,a._2+b._2,a._3+b._3))
   var SD1 = math.sqrt(((tempSD1._3/tempSD1._1)-(tempSD1._2/tempSD1._1)*(tempSD1._2/tempSD1._1))/2)
   var SD2 = math.sqrt(((tempSD2._3/tempSD2._1)-(tempSD2._2/tempSD2._1)*(tempSD2._2/tempSD2._1))/2);
   
   //根据SD1 SD2 调用本地模型进行预测：
   val conf = new SparkConf().setMaster("local[1]").setAppName("spark")
   val sc = SparkContext.getOrCreate(conf)
   val model = SVMModel.load(sc, "/Users/percy/Documents/course/project-training/big-data/hbr-analysis/code/model")

    //model.predict(Vectors.dense(SD1, SD2))
   val result: Double = model.predict(Vectors.dense(SD1, SD2))
   println(">>>>>> predict result: " + result)
   saveToMySQL(SD1,SD2,result.toInt,userName)
   
}

def saveToMySQL(SD1:Double,SD2:Double,result:Int,userName:String)
{
 val driver = "com.mysql.jdbc.Driver"  
 val url = "jdbc:mysql://localhost:3306/hbr_analysis"
 val username = "root"
 val password = "123456"
 var connection:Connection = null 
 Class.forName(driver)  
 connection = DriverManager.getConnection(url, username, password)
 val lTime = System.currentTimeMillis()
 val date:Date = new Date(lTime)
 var df:SimpleDateFormat=new SimpleDateFormat("YYYY-MM-DD HH:mm:ss")
 val finalTime = df.format(date)
 var health_status = "healthy"
 if(result == 0)
 {
   health_status = "unhealthy"
 }
 val sql = "insert into user_result (username,sd1,sd2,health_status,log_time) values (?,?,?,?,?)"
 println(sql)
 val prep = connection.prepareStatement(sql)
 prep.setString(1, userName)
 prep.setDouble(2, SD1)
 prep.setDouble(3,SD2)
 prep.setString(4,health_status)
 prep.setString(5,finalTime)
 prep.executeUpdate
 
}

}

