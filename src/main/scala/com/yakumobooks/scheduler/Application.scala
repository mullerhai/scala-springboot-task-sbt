package com.yakumobooks.scheduler

import org.springframework.boot.{Banner, SpringApplication, WebApplicationType}
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.PropertySource
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@PropertySource(value=Array("classpath:/application.properties"))
class Application

object Application {
//  def main(args: Array[String]): Unit = {
//    SpringApplication.run(classOf[Application])
//  }
  def main(args:Array[String]): Unit = {
    (new SpringApplicationBuilder)
      .bannerMode(Banner.Mode.CONSOLE)
      .sources(classOf[Application])
      .web(WebApplicationType.SERVLET)
      .headless(true)
      .run(args:_*)
  }
}
