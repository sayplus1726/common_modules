plugins {
    id("java")
    kotlin("plugin.lombok") version "1.9.22"
    id("io.freefair.lombok") version "8.1.0"
}

group = "com.saiha.util"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    compileOnly ("org.projectlombok:lombok")
    annotationProcessor ("org.projectlombok:lombok")

    implementation ("ch.qos.logback:logback-classic:1.4.1")
    implementation ("org.slf4j:slf4j-api:2.0.3")
}

tasks.test {
    useJUnitPlatform()
}