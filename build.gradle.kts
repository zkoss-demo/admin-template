plugins {
    war
    id("org.gretty") version "2.3.1"
}
group = "org.zkoss"
version = "1.0-SNAPSHOT"

gretty {
    servletContainer = "jetty9.3"
    jvmArgs = listOf("-Xmx2g")
}

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("http://mavensync.zkoss.org/eval")
        content {
            // this repository *only* contains artifacts with group specified
            includeGroup("io.keikai")
        }
    }
    maven {
        url = uri("http://mavensync.zkoss.org/maven2")
        content {
            // this repository *only* contains artifacts with group specified
            includeGroup("io.keikai")
        }
    }
}

dependencies {
    implementation("io.keikai:keikai-java-client:1.0.0-beta.20-Eval")
    providedCompile("javax.servlet:javax.servlet-api:3.1.0")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}