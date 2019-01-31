import gmex.Dependencies
import gmex.PluginIds
import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion

//description = "gMeX Dependency Management Plugin"

val kotlinVersion = getKotlinPluginVersion()

plugins {

//    id(PluginIds.Kotlin.KOTLIN)
    kotlin("jvm")

}

//gradlePlugin {
//    plugins {
//        create("simplePlugin") {
//            id = "gmex.dependency-management"
//            implementationClass = "gmex.DependencyManagementPlugin"
//        }
//    }
//}

dependencies {
    implementation(kotlin("stdlib", kotlinVersion))
    implementation(kotlin("reflect", kotlinVersion))
    compile(kotlin("gradle-plugin", kotlinVersion))
    compile(kotlin("allopen", kotlinVersion))

    implementation()
    testImplementation()

}

fun DependencyHandlerScope.implementation() {
    implementationKotlin()
}

fun DependencyHandlerScope.implementationKotlin() {
    implementation(Dependencies.Kotlin.KOTLIN)
}

fun DependencyHandlerScope.testImplementation() {
    testImplementationTest()
    testImplementationMock()
}

fun DependencyHandlerScope.testImplementationTest() {
    testImplementation(Dependencies.Test.JUNIT_COMPILE)
    testRuntimeOnly(Dependencies.Test.JUNIT_RUNTIME)
}

fun DependencyHandlerScope.testImplementationMock() {
    testImplementation(Dependencies.Mock.MOCK_K)
}

