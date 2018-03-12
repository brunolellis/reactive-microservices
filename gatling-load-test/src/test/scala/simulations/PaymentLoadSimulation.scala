package simulations

import java.util.UUID

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class PaymentLoadSimulation extends Simulation {

  val baseUrl = "http://localhost:8080"
  val sim_users = System.getProperty("SIM_USERS", "10").toInt
  val requestCount = 4
  
  val httpConf = http.baseURL(baseUrl)

  val paymentTest = repeat(requestCount) {
    exec(http("/payment")
      .post("/payment")
        .header("Content-Type", "application/json")
      .body(StringBody(
        s"""
           | {
           |  "from": "from account",
           |  "to": "to account",
           |  "amount": "1"
           | }
        """.stripMargin)
      )
      .check(status.is(201), jsonPath("$.paymentDate").exists))
      .pause(1 second, 2 seconds)
  }

  val scn = scenario("PaymentLoadSimulation")
    .exec(paymentTest)

  setUp(scn.inject(rampUsers(sim_users).over(30 seconds)).protocols(httpConf))
}
