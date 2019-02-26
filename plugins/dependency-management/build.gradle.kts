import org.gradle.api.internal.HasConvention
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion

description = "gMeX Dependency Management Plugin"

plugins {

    id(gmex.PluginIds.Java.GRADLE)
    id(gmex.PluginIds.Kotlin.KOTLIN)
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
    implementation()
    testImplementation()
}

fun DependencyHandlerScope.implementation() {
    implementationKotlin()
}

fun DependencyHandlerScope.implementationKotlin() {
    implementation(gmex.Dependencies.Kotlin.KOTLIN)
}

fun DependencyHandlerScope.testImplementation() {
    testImplementationTest()
    testImplementationMock()
    testImplementationBuildSrc()
}

fun DependencyHandlerScope.testImplementationTest() {
    testImplementation(gmex.Dependencies.Test.JUNIT_API)
    testRuntimeOnly(gmex.Dependencies.Test.JUNIT_ENGINE)

}

fun DependencyHandlerScope.testImplementationMock() {
    testImplementation(gmex.Dependencies.Mock.MOCK_K)
}

fun DependencyHandlerScope.testImplementationBuildSrc() {
    testImplementation(fileTree("${project.rootDir}/buildSrc/build/"))
}