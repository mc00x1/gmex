import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = getKotlinPluginVersion()

buildscript {

    val kotlinVersion = "1.3.11"

    repositories {
        gradlePluginPortal()
        maven("http://nexus/content/repositories/snapshots/")
        maven("http://nexus/content/repositories/releases/")
        maven("http://nexus/content/groups/public")
        maven("http://nexus/content/repositories/central/")
    }

    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
        classpath(kotlin("allopen", kotlinVersion))
    }
}

plugins {
    kotlin("jvm").version("1.3.11")
}

repositories {
    mavenLocal()
    maven("http://nexus/content/repositories/snapshots/")
    maven("http://nexus/content/repositories/releases/")
    maven("http://nexus/content/groups/public")
    maven("http://nexus/content/repositories/central/")
}

dependencies {
    compile(kotlin("stdlib", kotlinVersion))
    compile(kotlin("reflect", kotlinVersion))
    compile("org.gradle:gradle-kotlin-dsl:1.1.1")
}

allprojects {

    tasks.withType<Wrapper> {
        gradleVersion = "5.1.1"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
}

