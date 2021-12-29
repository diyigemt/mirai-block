import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("kapt") version "1.5.10"
    application
}

group = "net.diyigemt.miraiblock"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    val miraiVersion = "2.8.0"
    api("net.mamoe", "mirai-core-api", miraiVersion)     // 编译代码使用
    runtimeOnly("net.mamoe", "mirai-core", miraiVersion) // 运行时使用
    // https://mvnrepository.com/artifact/com.squareup.moshi/moshi-kotlin
    api("com.squareup.moshi:moshi-kotlin:1.12.0")
    // https://mvnrepository.com/artifact/com.squareup.moshi/moshi-kotlin-codegen
    api ("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("MainKt")
}