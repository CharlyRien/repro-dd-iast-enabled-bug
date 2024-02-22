plugins {
    java
    kotlin("jvm") version "1.9.22"
    id("org.springframework.boot") version "3.1.8"
    kotlin("plugin.serialization") version "1.9.22"
}

group = "me.chosante"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux:3.1.8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
}

kotlin {
    jvmToolchain(21)
}