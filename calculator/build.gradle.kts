plugins {
    id("java-library")
}

repositories {
    mavenCentral()
}

val YOUR_NAME = "YOUR_NAME_HERE"

dependencies {
    // Gives us NotImplementedException
    implementation("org.apache.commons:commons-lang3:3.12.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.assertj:assertj-core:3.22.0")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register<Zip>("packageAssignment") {
    archiveFileName.set("${project.name}-$YOUR_NAME.zip")
    from(layout.projectDirectory) {
        include("*.gradle.kts")
        include("src/**")
        include("gradle/**")
        include("gradlew*")
    }

    outputs.upToDateWhen { false }

    finalizedBy(tasks.getByPath("copyZip"))
}

tasks.register<Copy>("copyZip") {
    from(tasks.getByName<Zip>("packageAssignment").outputs)

    destinationDir = layout.projectDirectory.asFile
}

tasks.register<JavaExec>("source2pdf") {
    classpath = files("${project.projectDir}/source2pdf-all.jar")

    args = listOf("src", "-o", "./$YOUR_NAME.pdf")
}