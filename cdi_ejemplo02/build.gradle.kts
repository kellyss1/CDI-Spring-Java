plugins {
    id("java")
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.apache.openwebbeans/openwebbeans-impl
    implementation("org.apache.openwebbeans:openwebbeans-impl:4.0.2")
}
