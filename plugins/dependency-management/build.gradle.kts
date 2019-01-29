import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion

description = "gMeX Dependency Management Plugin"

val kotlinVersion = getKotlinPluginVersion()

plugins {
    `java-gradle-plugin`
    kotlin("jvm")
    kotlin("kapt")
}

gradlePlugin {
    plugins {
        create("simplePlugin") {
            id = "gmex.dependency-management"
            implementationClass = "gmex.DependencyManagementPlugin"
        }
    }
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation(kotlin("gradle-plugin-api"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.2")

    testRuntimeOnly( "org.junit.jupiter:junit-jupiter-engine:5.3.2")

}
