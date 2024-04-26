plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework:spring-core:6.0.16")
    implementation("org.springframework:spring-context:6.1.3")
    implementation("org.springframework:spring-web:5.3.10")
    implementation("org.springframework.boot:spring-boot-starter-web:2.6.4")
}

tasks.test {
    useJUnitPlatform()
}