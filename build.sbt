name := "cassy"

version := "1.0"

scalaVersion := "2.10.4"

resolvers += "Sonatype Public" at "https://oss.sonatype.org/content/groups/public/"

parallelExecution in Test := false

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.0.2",
  "org.apache.cassandra" % "cassandra-thrift" % "2.1.0",
  "org.apache.cassandra" % "cassandra-clientutil" % "2.1.0",
  "com.datastax.cassandra" % "cassandra-driver-core" % "2.0.4",
  "com.datastax.spark" %% "spark-cassandra-connector" % "1.0.0",
  "org.scalatest" % "scalatest_2.10" % "2.2.1" % "test"
)

unmanagedClasspath in Runtime <+= (baseDirectory) map { bd => Attributed.blank(bd) }