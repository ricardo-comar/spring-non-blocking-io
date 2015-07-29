# spring-non-blocking-io

Simple Spring Boot Project, purely based on [this example](http://blog.brunosimioni.com/jersey-jax-rs-non-blocking-io/).


### Stress Test script

```
package basic

import io.gatling.core.Predef._  
import io.gatling.http.Predef._  
import io.gatling.jdbc.Predef._  
import scala.concurrent.duration._  

class SpringBootOneSimulation extends Simulation {

  val rampUpTimeSecs = 5
  val testTimeSecs   = 30
  val noOfUsers      = 3000
  val minWaitMs      = 1000 milliseconds
  val maxWaitMs      = 3000 milliseconds

  val baseURL      = "http://localhost:8080"
  val baseName     = "spring-boot-one"
  val requestName  = baseName + "-request"
  val scenarioName = baseName + "-scenario"
  val URI          = "/nio/sync?minMs=500&maxMs=1000"

  val httpConf = http.baseURL(baseURL)

  val scn = scenario(scenarioName)
    .during(testTimeSecs) {
      exec(
        http(requestName)
          .get(URI)
          .check(status.is(200))
      )
      .pause(minWaitMs, maxWaitMs)
    }

  setUp(scn.inject(rampUsers(noOfUsers) over (rampUpTimeSecs)))
    .protocols(httpConf)
}
```

