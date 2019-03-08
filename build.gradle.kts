import gmex.PluginIds
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(gmex.PluginIds.JetBrains.KOTLIN).version(gmex.Versions.Plugin.KOTLIN)
}

val kotlinVersion = getKotlinPluginVersion()

allprojects {
    repositories {
        maven("http://nexus/content/repositories/snapshots/")
        maven("http://nexus/content/repositories/releases/")
        maven("http://nexus/content/groups/public")
        maven("http://nexus/content/repositories/central/")
        google()
        gradlePluginPortal()
        mavenLocal()
    }

    tasks {
        withType<Wrapper> {
            gradleVersion = gmex.Versions.Gradle.WRAPPER
            distributionType = Wrapper.DistributionType.ALL
        }

        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = gmex.Versions.Java.TARGET_JVM
        }

        withType<Test> {
            useJUnitPlatform {
                includeEngines("junit-jupiter", "junit-vintage")
            }
        }

        withType<JavaCompile> {
            sourceCompatibility = gmex.Versions.Java.TARGET_JVM
            targetCompatibility = gmex.Versions.Java.TARGET_JVM
        }
    }
}

dependencies {
    implementation(kotlin("stdlib", kotlinVersion))
    implementation(kotlin("reflect", kotlinVersion))
    compile(kotlin("gradle-plugin", kotlinVersion))
    compile(kotlin("allopen", kotlinVersion))

    // Make the root project archives configuration depend on every sub-project
    subprojects.forEach {
        archives(it)
    }
}


