# spring-non-blocking-io

Simple Spring Boot Project, purely based on [this example](http://blog.brunosimioni.com/jersey-jax-rs-non-blocking-io/).

Created using Spring Boot, with Maven 3, Spring Batch and [Actuator](http://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html#production-ready-endpoints). 

### Usage
- Download the repo
- Package with `mvn package`
- And run with `java -jar target/spring-non-blocking-io-0.0.1-SNAPSHOT.jar`
- Call [the api](localhost:8080/api/nio/sync?minMs=200&maxMs=300) and wait for the response. 

### How it works
- An instance will be online in a few seconds. 
- Every time you call the service, a simple `Thread.sleep()` will emulate a very complex process, sleeping for X milliseconds, based on the interval passed by the parameters _minMs_ and _maxMs_.
- You can also test a second approach using a ManagedAsync method, just changing the URI from ../nio/sync.. to ../nio/async..

### Stress Test script

```Scala
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
  val URI          = "/api/nio/sync?minMs=500&maxMs=1000"

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
