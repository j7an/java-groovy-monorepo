// feature-x-groovy/build.gradle.kts
plugins {
    id("groovy") // Apply the groovy plugin (implicitly applies java)
}

// Explicitly define the Groovy version dependency
dependencies {
    // Depend on the shared core module
    implementation(project(":core"))

    // Add the specific Groovy version (4.0.26)
    // The groovy plugin itself doesn't enforce the version, you need the dependency
    implementation("org.apache.groovy:groovy:4.0.26")

    // Spock framework for testing Groovy code (depends on Groovy 4.0)
    testImplementation(platform("org.spockframework:spock-bom:2.4-M1-groovy-4.0")) // Use Spock BOM if available for version alignment
    testImplementation("org.spockframework:spock-core") {
        exclude(group = "org.codehaus.groovy") // Exclude transitive groovy to use the one defined above
    }
    testImplementation("org.spockframework:spock-junit4") // Optional: if you need JUnit 4 integration/rules with Spock

    // You still need a JUnit platform runner for Spock 2.x tests
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Add REST Assured for API testing
    testImplementation("io.rest-assured:rest-assured:5.5.1") // Use the desired version

    // Add other Groovy modules if needed (e.g., groovy-sql, groovy-json)
    // implementation("org.apache.groovy:groovy-json:4.0.26")
}

// Optional: Configure Groovy compilation options if needed
// tasks.withType<GroovyCompile> {
//     groovyOptions.forkOptions.jvmArgs = listOf("-Xmx1024m")
// }