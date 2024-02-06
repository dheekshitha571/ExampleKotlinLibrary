plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("maven-publish")
}


publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["java"])

            groupId = "com.github.dheekshitha571"
            artifactId = "number-conversions"
            version = "1.0"
        }
    }
}
