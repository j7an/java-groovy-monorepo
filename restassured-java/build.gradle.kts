// feature-x-java/build.gradle.kts
plugins {
    id("java-library") // Or just "java" if it's an application/final component
}

dependencies {
    // Depend on the shared core module
    implementation(project(":core"))

    // JUnit 5 dependencies for testing
    testImplementation(platform("org.junit:junit-bom:5.12.2")) // Use JUnit BOM
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine") // Ensure the engine is included

    // Add REST Assured for API testing
    testImplementation("io.rest-assured:rest-assured:5.5.1") // Use the desired version
}