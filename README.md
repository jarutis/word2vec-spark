# word2vec-spark

I ran it with
```
$ sbt assembly
$ SPARK_HOME/spark-submit --class "s
ome.ml.Word2VecExample" --master local[4] target/scala-2.10/word2vec-spark.jar dracula.t
xt
```
