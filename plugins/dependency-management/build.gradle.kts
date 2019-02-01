import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion

description = "gMeX Dependency Management Plugin"

plugins {

    id(gmex.PluginIds.Kotlin.KOTLIN)
    id(gmex.PluginIds.Java.GRADLE)

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
}

fun DependencyHandlerScope.testImplementationTest() {
    testImplementation(gmex.Dependencies.Test.JUNIT_COMPILE)
    testRuntimeOnly(gmex.Dependencies.Test.JUNIT_RUNTIME)
}

fun DependencyHandlerScope.testImplementationMock() {
    testImplementation(gmex.Dependencies.Mock.MOCK_K)
}

