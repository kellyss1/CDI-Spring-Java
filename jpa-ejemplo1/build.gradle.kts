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
    implementation("org.hibernate:hibernate-core:6.6.4.Final")
    implementation("org.hibernate:hibernate-community-dialects:6.6.4.Final")

    implementation("org.xerial:sqlite-jdbc:3.47.0.0")
}
