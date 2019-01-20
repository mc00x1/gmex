rootProject.name = "gmex"

rootProject.children.stream().map {
    it.name = rootProject.name + "-" + it.name.replace('/', '-')
}

fileTree(".") {
    include("**/*/build.gradle.kts")
    exclude("*")
    exclude("build.gradle")
    exclude("build.gradle.kts")
    exclude("settings.gradle.kts")
}.visit {
    println(this)
//    include(this.relativePath.toString())
}



