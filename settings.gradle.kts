includeAllSubProjects()
setProperSubProjectNames()

fun includeAllSubProjects() {
    fileTree(".").matching {
        exclude("build.gradle")
        exclude("build.gradle.kts")
        exclude("buildSrc/**/*build.gradle*")
        include("**/*build.gradle")
        include("**/*build.gradle.kts")
    }.forEach {
        val path = relativePath(it.parent)
//        include(path)
    }
}

fun setProperSubProjectNames() {
    rootProject.children.stream().forEach {
        it.name = "${rootProject.name}-${it.name.replace('/', '-')}"
    }
}