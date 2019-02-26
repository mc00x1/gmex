plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    maven("http://nexus/content/repositories/snapshots/")
    maven("http://nexus/content/repositories/releases/")
    maven("http://nexus/content/groups/public")
    maven("http://nexus/content/repositories/central/")
}

dependencies {
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
}

