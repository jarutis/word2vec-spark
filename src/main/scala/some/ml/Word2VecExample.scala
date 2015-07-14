package some.ml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.deeplearning4j.spark.impl.multilayer.SparkDl4jMultiLayer
import org.deeplearning4j.spark.models.embeddings.word2vec.Word2Vec
import org.deeplearning4j.spark.models.embeddings.word2vec.Word2VecPerformer
import org.deeplearning4j.util.SerializationUtils

import java.io.File

object Word2VecExample {
  def main(args: Array[String]) {
    val sparkConf = new SparkConf()
      .set(SparkDl4jMultiLayer.AVERAGE_EACH_ITERATION, "false")
      .set(Word2VecPerformer.NEGATIVE,String.valueOf("0"))
      .set("spark.akka.frameSize", "100")
      .set(Word2VecPerformer.VECTOR_LENGTH,String.valueOf(300))
      .setAppName("Word2Vec Spark")

    System.out.println("Setting up Spark Context...")

    val sc = new SparkContext(sparkConf)

    val rdd = sc.textFile(new File(args(0)).toURI().toString())
    val vec = new Word2Vec()
    val table = vec.train(rdd)

    SerializationUtils.saveObject(table,new File("table.ser"))
    System.out.println("Saved model")
  }
}
