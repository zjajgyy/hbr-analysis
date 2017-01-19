package com.xiang

/**
  * Created by hmh on 2017/1/8.
  */
import java.sql.{Connection, DriverManager}
import java.text.SimpleDateFormat
import java.util.Date

class MySqlConnection {

  //  val user="hbr"
//  val password = "hbrxiang123"
//  val host="121.194.62.243"
//  val database="hbr_analysis"


  val user="root"
  val password = "123456"
  val host="localhost"
  val database="hbr_analysis"

  val conn_str = "jdbc:mysql://"+host +":3306/"+database+"?user="+user+"&password=" + password
  println(conn_str)
  var connection:Connection = null

  def connectMySql(): Unit ={
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    if(connection == null){
      connection = DriverManager.getConnection(conn_str)
      println("connected to mysql")
    }
  }

  def saveToMySQL(SD1:Double,SD2:Double,result:Int,patient_id:String): Unit ={

    connectMySql()

    if(connection != null){
      println("save to mysql..........")
      var health_status = "healthy"
      if(result == 0)
      {
        health_status = "unhealthy"
      }
      val lTime = System.currentTimeMillis()
      val date:Date = new Date(lTime)
      val df:SimpleDateFormat=new SimpleDateFormat("YYYY-MM-DD HH:mm:ss")
      val finalTime = df.format(date)
      try {

        val statement = connection.createStatement()
        val resultSet = statement.executeQuery("select * from patient_result where patient_id = "+ patient_id+" limit 1")
        if ( resultSet.next() ) {
          //TODO 用户已存在，直接更新SD和健康状态
          println("mysql更新数据")
          val sql = "update patient_result set sd1="+SD1+",sd2="+SD2+",health_status="+result+",log_time='"+finalTime +"' where patient_id = "+patient_id
          println(sql)
          val prep = connection.prepareStatement(sql)
          //prep.setString(1, patient_id)
//          prep.setDouble(1, SD1)
//          prep.setDouble(2,SD2)
//          prep.setString(3,health_status)
//          prep.setString(4,finalTime)
          prep.executeUpdate
        }else{
          //TODO 用户不存在，创建用户并插入数据
          println("mysql插入数据")
          val sql = "insert into patient_result (name,sd1,sd2,health_status,log_time) values (?,?,?,?,?)"
          println(sql)
          val prep = connection.prepareStatement(sql)
          prep.setString(1, patient_id)
          prep.setDouble(2, SD1)
          prep.setDouble(3,SD2)
          prep.setString(4,health_status)
          prep.setString(5,finalTime)
          prep.executeUpdate

        }
      } catch {
        case e => e.printStackTrace
        //case _: Throwable => println("ERROR")
      }
      connection.close()
    }else{
      println("数据库未连接")
    }
  }

}
