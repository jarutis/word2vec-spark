name := "Word2Vec Spark"

organization := "Vinted"

version := "0.0.1"

scalaVersion := "2.10.4"

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.4.0" % "provided" withSources() withJavadoc(),
  "org.deeplearning4j" % "dl4j-spark-nlp" % "0.0.3.3.5.alpha2-SNAPSHOT" withSources(),
  "org.deeplearning4j" % "dl4j-spark" % "0.0.3.3.5.alpha2-SNAPSHOT" withSources(),
  "org.nd4j" % "nd4j-java" % "0.0.3.5.5.6-SNAPSHOT" withSources()
)

jarName in assembly := "word2vec-spark.jar"

mergeStrategy in assembly := {
  case x if x.startsWith("META-INF") => MergeStrategy.discard
  case x if x.endsWith(".html") => MergeStrategy.discard
  case x if x.contains("slf4j-api") => MergeStrategy.last
  case _ => MergeStrategy.first
}
