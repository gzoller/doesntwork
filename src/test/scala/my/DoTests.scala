package my

import org.scalatest._
import org.scalatest.Matchers._
import org.apache.spark.SparkContext

class DoTests extends FunSpec with BeforeAndAfterAll with GivenWhenThen {

	var sc : SparkContext = _
	val doit = new Doit(){}

	override def beforeAll() {
	  	sc = new SparkContext("local","test",doit.conf)
	}

	override def afterAll() {
		sc.stop
		System.clearProperty("spark.master.port")
	}

	describe("Service Tests") {
		it("Induce failure of test to start") {
			doit.fn(sc)
		}
	}
}