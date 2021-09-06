// Kotlin DSL Primer https://docs.gradle.org/current/userguide/kotlin_dsl.html
plugins {
    war
    id("org.gretty") version "3.0.6"
}
group = "org.zkoss"
version = "1.0-SNAPSHOT"

gretty {
    servletContainer = "jetty9.4"
}

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("https://mavensync.zkoss.org/eval")
    }
}

val zkVer = "9.6.0.1-Eval"

dependencies {
    implementation("org.zkoss.zk:zkmax:${zkVer}")
    implementation("org.zkoss.zk:zuti:${zkVer}")
    implementation("org.zkoss.theme:iceblue_c:${zkVer}")
    implementation("org.zkoss.chart:zkcharts:7.2.2.0-Eval")
    implementation("org.webjars:bootstrap:4.6.0")
}

tasks.war {
    archiveFileName.set("admin-template.war")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
