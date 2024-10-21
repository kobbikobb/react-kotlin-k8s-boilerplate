plugins {
    kotlin("jvm") version "1.9.0"
    application
    id("io.ktor.plugin") version "2.3.0"
}

application {
    mainClass.set("com.kobbikobb.ApiAppKt")
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:2.3.0")
    implementation("io.ktor:ktor-server-netty-jvm:2.3.0")
    implementation("ch.qos.logback:logback-classic:1.4.11")
}
