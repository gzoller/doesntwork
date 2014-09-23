package my

import org.scalatest._
import org.scalatest.Matchers._
import org.apache.spark.SparkContext

class DoTests extends FunSpec with BeforeAndAfterAll with GivenWhenThen {

	var sc : SparkContext = _
	var doit : Doit = _

	override def beforeAll() {
	  	doit = Doit()
	  	sc = new SparkContext(doit.conf)
	}

	override def afterAll() {
		sc.stop
		System.clearProperty("spark.master.port")
	}

	describe("Service Tests") {
		it("Induce failure of test to start") {
			val n1 = System.currentTimeMillis;
			doit.fn(sc)
			println("Time: "+(System.currentTimeMillis - n1)+"ms")
			val n2 = System.currentTimeMillis;
			doit.fn(sc)
			println("Time: "+(System.currentTimeMillis - n2)+"ms")
			val n3 = System.currentTimeMillis;
			doit.fn(sc)
			println("Time: "+(System.currentTimeMillis - n3)+"ms")
		}
	}
}