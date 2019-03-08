description = "Simple gmex.dependency-management Plugin Test Project"

plugins {
    kotlin("jvm").version("1.3.11")
}

repositories {
    mavenLocal()
    gradlePluginPortal()
}

sourceSets {
    create("testProjects") {
        allSource.setSrcDirs(listOf("src/test/projects"))
    }
    println(getByName("testProjects").allSource.srcDirs)
}

