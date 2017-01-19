/**
  * Created by xiaoyu on 17-1-10.
  */
import org.apache.spark.mllib.classification.SVMModel
import org.apache.spark.sql.SparkSession
import org.apache.spark.mllib.linalg.Vectors

object Test extends App {
  val spark = SparkSession.builder()
    .master("local")
    .appName("MLTest")
    .getOrCreate()
  val model = SVMModel.load(spark.sparkContext, "/home/xiaoyu/model")
  println(model.predict(Vectors.dense(0.1, 0.3)))
}
