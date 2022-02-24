plugins {
    id("java")
    id("org.springframework.boot") version "2.5.7"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-parent:2.5.7")
    implementation("org.springframework.shell:spring-shell-starter:2.0.1.RELEASE")

    implementation(project(":calculator"))

    implementation("info.picocli:picocli:4.6.3")
    implementation("info.picocli:picocli-shell-jline3:4.6.3")
}


springBoot {
    mainClass.set("csc22100.rpn_calculator.cli.RpnCalculatorCli")
}

tasks.withType<org.springframework.boot.gradle.tasks.run.BootRun>{
    standardInput = System.`in`
}