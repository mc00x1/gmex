import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

description = "BuildSrc Module"

plugins {
    `kotlin-dsl`
//    id("org.gradle.kotlin.kotlin-dsl").version("1.2.5")
//    kotlin("jvm").version("1.3.20")
}

//val kotlinVersion = getKotlinPluginVersion()

repositories {
    gradlePluginPortal()
//    maven("https://repo.gradle.org/gradle/libs-releases-local/")
//    maven("https://dl.bintray.com/kotlin/kotlinx/")
    maven("http://nexus/content/repositories/snapshots/")
    maven("http://nexus/content/repositories/releases/")
    maven("http://nexus/content/groups/public")
    maven("http://nexus/content/repositories/cenltral/")
}

dependencies {
//    implementation(kotlin("stdlib", kotlinVersion))
//    implementation(kotlin("reflect", kotlinVersion))
//    compile(kotlin("gradle-plugin", kotlinVersion))
//    compile("org.gradle:gradle-kotlin-dsl:1.1.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.0")
}

tasks {
    withType<Test> {
        useJUnitPlatform {
            includeEngines("junit-jupiter", "junit-vintage")
        }
    }

    withType<Wrapper> {
        distributionType = Wrapper.DistributionType.ALL
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

}

