plugins {
    id("java")
    id("io.freefair.lombok") version "8.10.2"
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-core:6.2.0")
    implementation("org.springframework:spring-context:6.2.0")

    implementation("com.zaxxer:HikariCP:6.2.0")
    implementation("org.xerial:sqlite-jdbc:3.47.0.0")
}