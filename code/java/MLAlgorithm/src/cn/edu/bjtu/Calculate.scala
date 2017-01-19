package cn.edu.bjtu

import java.io.PrintWriter

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.math._
/**
  * Created by xiaoyu on 17-1-10.
  */
object Calculate extends App{
  def calSD(path: String, label: Int, pw: PrintWriter): Unit = {
    val file = Source.fromFile(path)
    val data = file.getLines().map[Double](_.toDouble).toBuffer
    var x = data.clone()
    var y = data.clone()
    x.remove(0)
    y.remove(data.size - 1)
    val pos = x.zip(y)
    val sum = pos.reduce((x, y) => (x._1 + y._1, x._2 + y._2))
    val avg = (sum._1/pos.size, sum._2/pos.size)
    val SD1 = pos.fold[(Double, Double)](0.0, 0.0)(
      (x, y) => {
        (
          x._1 + pow((y._1 - avg._1) - (y._2 - avg._2), 2)/2, 0
        )
      }
    )
    val SD2 = pos.fold[(Double, Double)](0.0, 0.0)(
      (x, y) => {
        (
          x._1 + pow((y._1 - avg._1) + (y._2 - avg._2), 2)/2, 0
        )
      }
    )
    val SD = (sqrt(SD1._1/pos.size), sqrt(SD2._1/pos.size))
    pw.write(s"${label} 1:${SD._1} 2:${SD._2}\n")
  }


  val pw = new PrintWriter("/home/xiaoyu/result.txt")

  for(i <- 1 to 15) {
    calSD(s"/home/xiaoyu/data/healthy/healthy/$i.txt", 1, pw)
  }

  for(i <- 1 to 17) {
    calSD(s"/home/xiaoyu/data/unhealthy/unhealthy/$i.txt", 0, pw)
  }

  pw.close()

}
