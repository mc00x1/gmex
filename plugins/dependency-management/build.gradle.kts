description = "gMeX Dependency Management Plugin"

repositories {
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

plugins {
    id(gmex.PluginIds.Java.GRADLE)
    id(gmex.PluginIds.JetBrains.KOTLIN)
}

gradlePlugin {
    plugins {
        create("dependencyManagementPlugin") {
            id = "gmex.dependency-management"
            implementationClass = "DependencyManagementPlugin"
        }
    }
}

sourceSets {
    create("testProjects") {
        allSource.setSrcDirs(listOf("src/test/projects"))
    }
}

dependencies {
    implementation()
    testImplementation()
}

fun DependencyHandlerScope.implementation() {
    implementationKotlin()
    implementationBuildSrc()
    implementationSpringDependencyManagement()
}

fun DependencyHandlerScope.implementationKotlin() {
    implementation(gmex.Dependencies.Kotlin.KOTLIN)
}

fun DependencyHandlerScope.implementationBuildSrc() {
    implementation(fileTree("${project.rootDir}/buildSrc/build/"))
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

fun DependencyHandlerScope.implementationSpringDependencyManagement() {
    implementation(gmex.Dependencies.Spring.DEPENDENCY_MANAGEMENT)
}
