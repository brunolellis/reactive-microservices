package simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PaymentLoadSimulation extends Simulation {

  private val baseUrl = "http://localhost:8080"
  private val endpoint = "/payment"
  private val contentType = "application/json"
  private val requestCount = 4

  private val simUsers = System.getProperty("SIM_USERS", "1").toInt

  private val httpConf = http
    .baseURL(baseUrl)
    .acceptHeader("application/json;charset=UTF-8")

  private val paymentTest = repeat(requestCount) {
    exec(http("payment-test")
      .post(endpoint)
      .header("Content-Type", contentType)
      .body(StringBody(
        s"""
           | {
           |  "from": "from account",
           |  "to": "to account",
           |  "amount": "1"
           | }
         """.stripMargin
      )).check(status.is(201)))
  }
  private val scn = scenario("PaymentLoadSimulation")
    .exec(paymentTest)

  setUp(scn.inject(atOnceUsers(simUsers))).protocols(httpConf)
}

