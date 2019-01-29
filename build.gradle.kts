import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm").version("1.3.20").apply(true)
}

val kotlinVersion = getKotlinPluginVersion()
val gradleWrapperVersion = "5.1.1"
val jvmTarget = JavaVersion.VERSION_1_8

allprojects {
    repositories {
        google()
        mavenLocal()
        gradlePluginPortal()
        maven("http://nexus/content/repositories/snapshots/")
        maven("http://nexus/content/repositories/releases/")
        maven("http://nexus/content/groups/public")
        maven("http://nexus/content/repositories/central/")
    }

    tasks {
        withType<Wrapper> {
            gradleVersion = gradleWrapperVersion
        }

        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = jvmTarget.toString()
        }

        withType<Test> {
            useJUnitPlatform {
                includeEngines("junit-jupiter", "junit-vintage")
            }
        }

        withType<JavaCompile> {
            sourceCompatibility = jvmTarget.toString()
            targetCompatibility = jvmTarget.toString()
        }
    }
}

val gmexTestCompile: Configuration by configurations.creating
val gmexTestRuntime: Configuration by configurations.creating

dependencies {
    gmexTestCompile(project(":gmex-dependencies-test-compile"))
    gmexTestRuntime(project(":gmex-dependencies-test-runtime"))

    //    implementation(kotlin("stdlib", kotlinVersion))
    //    implementation(kotlin("reflect", kotlinVersion))
    //    compile(kotlin("gradle-plugin", kotlinVersion))
    //    compile(kotlin("allopen", kotlinVersion))
}


