plugins {
    java
}

group = "io.github.sullis"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

val assertjVersion = "4.0.0-M1"
val awaitilityVersion = "4.3.0"
val commonsIoVersion = "2.22.0"
val commonsLang3Version = "3.20.0"
val jacksonVersion = "2.22.0"
val junitBomVersion = "6.1.0"
val logbackVersion = "1.5.35"
val slf4jVersion = "2.0.18"
val testcontainersBomVersion = "2.0.5"

dependencies {
    implementation(platform("org.junit:junit-bom:$junitBomVersion"))
    implementation(platform("org.testcontainers:testcontainers-bom:$testcontainersBomVersion"))

    implementation("org.apache.commons:commons-lang3:$commonsLang3Version")
    implementation("commons-io:commons-io:$commonsIoVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("org.slf4j:jul-to-slf4j:$slf4jVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.assertj:assertj-core:$assertjVersion")
    testImplementation("org.awaitility:awaitility:$awaitilityVersion")
    testRuntimeOnly("ch.qos.logback:logback-classic:$logbackVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
    maxParallelForks = 8
    jvmArgs("-Dfile.encoding=UTF-8")
}
