import org.apache.spark.mllib.classification.SVMWithSGD
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.sql.SparkSession
import java.util.Random

import scala.collection.mutable.Set
import org.apache.spark.mllib.regression.LabeledPoint

import scala.collection.mutable.ArrayBuffer

object MLTest extends App {
  /**
  * Created by gxy on 2017/1/8.
  */
  //Since Spark 2.0+
  val spark = SparkSession.builder()
    .master("local")
    .appName("MLTest")
    .getOrCreate()

  val data = MLUtils.loadLibSVMFile(spark.sparkContext, "/home/xiaoyu/result.txt")
  val aucSet = Set[Double]()

  val collected_data = data.collect()

  //Generate 100 model
  for(i <- 1 to 100) {

    //BootStrapping for small dataset
    val sample: ArrayBuffer[LabeledPoint] = ArrayBuffer()
    for (i <- 0 to collected_data.length - 1) {
      sample.append(collected_data((new Random()).nextInt(collected_data.length - 1)))
    }
    val test_set = collected_data.toSet[LabeledPoint].&~(sample.toSet[LabeledPoint])
    val test: ArrayBuffer[LabeledPoint] = ArrayBuffer()

    for (element <- test_set) {
      test.append(element)
    }
    val training = spark.sparkContext.parallelize(sample.toList)
    val testing = spark.sparkContext.parallelize(test.toList)
    //Training set and testing set

    // Run training algorithm to build the model
    val numIterations = 100
    val model = SVMWithSGD.train(training, numIterations)

    // Set threshold.
    model.setThreshold(0.12)

    val scoreAndLabels = testing.map {
      point =>
        val score = model.predict(point.features)
        (score, point.label)
    }

    // Get evaluation metrics.
    val metrics = new BinaryClassificationMetrics(scoreAndLabels)
    val auROC = metrics.areaUnderROC()

    println("Area under ROC = " + auROC)
    println(scoreAndLabels.collect().toBuffer)
    if(!aucSet.contains(auROC)){
      aucSet.add(auROC)
      model.save(spark.sparkContext, s"/home/xiaoyu/auROC/${auROC}")
    }

  }



}
