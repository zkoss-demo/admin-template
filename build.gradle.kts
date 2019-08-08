// Kotlin DSL Primer https://docs.gradle.org/current/userguide/kotlin_dsl.html
plugins {
    war
    id("org.gretty") version "2.3.1"
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
        url = uri("http://mavensync.zkoss.org/eval")
    }
    maven {
        url = uri("http://jaspersoft.jfrog.io/jaspersoft/third-party-ce-artifacts/")
    }// for com.lowagie:itext:2.1.7.js6
}

val zkVer = "8.6.2-Eval"

dependencies {
    implementation("org.zkoss.zk:zkmax:${zkVer}")
    implementation("org.zkoss.zk:zuti:${zkVer}")
    implementation("org.zkoss.theme:iceblue_c:${zkVer}")
    implementation("org.zkoss.chart:zkcharts:3.0.3-Eval")
    implementation("org.webjars:bootstrap:4.3.1")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
