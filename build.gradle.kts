import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
    application
}

group = "guru.drako.examples"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

object Version {
    const val JUNIT = "5.6.1"
    const val KTX_COROUTINES = "1.3.5"
    const val version = "5.0.2"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    testImplementation(kotlin("test-junit5"))
    testImplementation(kotlin("test"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.KTX_COROUTINES}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:${Version.KTX_COROUTINES}")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${Version.JUNIT}")
    testImplementation("org.junit.jupiter:junit-jupiter-params:${Version.JUNIT}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Version.JUNIT}")
    implementation("io.kotest:kotest-framework-engine:5.0.2")}

application {
    mainClassName = "guru.drako.examples.gildedrose.MainKt"
}

tasks {
    "wrapper"(Wrapper::class) {
        gradleVersion = "6.3"
    }

    withType<Test> {
        useJUnitPlatform()
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}
tasks.test {
    useJUnitPlatform()
}
