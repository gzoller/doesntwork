package my

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

import com.datastax.spark.connector._

trait Doit {
  val conf = new SparkConf().setAppName("Simple Application").setMaster("local")
  /*
  val sc = new SparkContext(conf)
  
  val ts = System.currentTimeMillis()
  val textFile = sc.textFile("/usr/share/dict/web2")
  val max = textFile.map( word => (word.length,word) ).reduce( (a,b) => if(a._1 > b._1) a else b )
  println("Max: "+max)
  println(s"Time: ${System.currentTimeMillis - ts}")
  */

  def fn( sc:SparkContext ) {
	val rdd = sc.cassandraTable("myks","users")
	val rr = rdd.first
	println("Cassy: "+rr)
  }

}