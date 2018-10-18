
name := "scala-spring-task"

version := "0.1.0"

organization := "com.yakumobooks"

scalaVersion := "2.11.7"
classpathTypes += "maven-plugin"
resolvers ++= Seq(
  "Spring GA Repository"        at "http://repo.spring.io/release",
  "Spring Milestone Repository" at "http://repo.spring.io/milestone"
)
libraryDependencies += "ch.qos.logback" % "logback-core" % "1.1.2"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"

libraryDependencies += "org.slf4j" % "jcl-over-slf4j" % "1.7.12"

libraryDependencies += "org.slf4j" % "log4j-over-slf4j" % "1.7.12"

libraryDependencies += "io.dropwizard.metrics" % "metrics-core" % "3.1.2"

libraryDependencies += "org.springframework" % "spring-core" % "4.1.6.RELEASE" exclude("commons-logging", "commons-logging")

libraryDependencies += "org.springframework.boot" % "spring-boot" % "2.0.5.RELEASE"

libraryDependencies += "org.springframework.boot" % "spring-boot-autoconfigure" % "2.0.5.RELEASE"

libraryDependencies += "org.springframework.boot" % "spring-boot-starter-logging" % "2.0.5.RELEASE"

libraryDependencies += "org.yaml" % "snakeyaml" % "1.14"

//libraryDependencies += "org.springframework.boot" % "spring-boot-starter-actuator" % "2.0.5.RELEASE"
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-webflux
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-webflux" % "2.0.5.RELEASE"
// https://mvnrepository.com/artifact/org.springframework/spring-webflux
//libraryDependencies += "org.springframework" % "spring-webflux" % "5.1.1.RELEASE"

libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % "2.0.5.RELEASE"
//exclude("org.springframework.boot","spring-boot-starter-tomcat")

//mainClass  in assembly := Some("com.tz.app.tzApplication")
scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-deprecation",
  "-unchecked",
  "-feature")

val springBootVersion    = "2.0.5.RELEASE"
libraryDependencies ++= {
  Seq(
    "org.springframework.boot" % "spring-boot-starter" % springBootVersion
  )
}
exportJars := true
mainClass in assembly := Some("com.yakumobooks.scheduler.Application")
mainClass in (Compile ,run):= Some("com.yakumobooks.scheduler.Application")
assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs @ _*)               => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".properties" => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".xml"        => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".types"      => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".class"      => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".json"       => MergeStrategy.last
  case PathList(ps @ _*) if ps.last endsWith ".provides"   => MergeStrategy.last
  case PathList(ps @ _*) if ps.last endsWith ".factories"  => MergeStrategy.last
  case "application.conf"                                  => MergeStrategy.concat
  case "unwanted.txt"                                      => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

// if you remove commentout the following line, this script set the environment properties to the Spring Boot's LaunchScript regardless of the value of the configuration file
//assemblyOption in assembly := (assemblyOption in assembly).value.copy(prependShellScript = Some({
//  val props = Map[String, String](
//    "initInfoProvides"         -> "yakumobooks.com"
//      ,"initInfoShortDescription" -> "task scheduler application"
//      ,"initInfoDescription"      -> ""
//      // ,"confFolder"               -> ""
//      // ,"pidFolder"                -> ""
//      // ,"logFolder"                -> ""
//      ,"mode"                     -> "service"
//      // ,"useStartStopDaemon"       -> ""
//  )
//  val scu="https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-tools/spring-boot-loader-tools/src/main/resources/org/springframework/boot/loader/tools/launch.script"
//  val placeholder_regex = "\\{\\{(\\w+)(:.*?)?\\}\\}(?!\\})".r
//  val launchScriptsUrl = s"https://raw.githubusercontent.com/spring-projects/spring-boot/v${springBootVersion}/spring-boot-tools/spring-boot-loader-tools/src/main/resources/org/springframework/boot/loader/tools/launch.script"
//  scala.io.Source.fromURL(scu, "UTF-8")
//    .getLines
//    .toSeq
//    .map(placeholder_regex.replaceAllIn(_, m =>
//      props.getOrElse(m.group(1), s"${m.group(2).replace("$","\\$").substring(1)}").stripLineEnd))
//
//}))

//assemblyJarName in assembly := s"${name.value}-${version.value}.jar"
assemblyJarName in assembly := s"${name.value}.jar"
