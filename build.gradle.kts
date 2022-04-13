plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.10"
    id("org.jetbrains.kotlin.kapt") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.3.2"
}

version = "0.1"
group = "com.example"

val kotlinVersion = project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("io.micronaut:micronaut-validation")
    // https://mvnrepository.com/artifact/io.micronaut.aws/micronaut-function-aws
    implementation("io.micronaut.aws:micronaut-function-aws:3.2.2")
    // https://mvnrepository.com/artifact/io.micronaut/micronaut-function-client
    implementation("io.micronaut:micronaut-function-client:3.4.1")
    // https://mvnrepository.com/artifact/org.junit.platform/junit-platform-runner
    testImplementation("org.junit.platform:junit-platform-runner:1.8.2")
    // https://mvnrepository.com/artifact/org.jetbrains.spek/spek-junit-platform-engine
    testImplementation("org.jetbrains.spek:spek-junit-platform-engine:1.1.5")
    // https://mvnrepository.com/artifact/org.jetbrains.spek/spek-api
    testImplementation("org.jetbrains.spek:spek-api:1.1.5")

    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

}


application {
    mainClass.set("com.example.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
}


