package gmex

import org.gradle.testfixtures.ProjectBuilder
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.gradle.tooling.GradleConnector
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.io.File
import java.io.OutputStreamWriter


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DependencyManagementPluginUnitTest {

    private val testGroup = "test-group"
    private val testArtifact = "test-artifact"
    private val testVersion = "test-version"

    fun setup() {}

    @Test
    fun testInstantiate() {
        installPluginIntoMavenLocal()
        installResolvableArtifact(testGroup, testArtifact, testVersion)
    }

    private fun installPluginIntoMavenLocal() {
//        TODO("not implemented")
    }

    private fun installResolvableArtifact(group: String, artifact: String,
                                          version: String): Boolean {

        val project = ProjectBuilder.builder().withName(artifact).build()

        project.pluginManager.apply("java")
        project.pluginManager.apply("maven")
        project.pluginManager.apply("maven-publish")

//        GradleConnector.newConnector().connect()
        project.group = group
        project.version = version

        val buildFile = File(project.projectDir, "build.gradle.kts")
        buildFile.createNewFile()
        buildFile.writeText("""
                plugins {
                    id("java")
                    id("maven")
                    id("maven-publish")
                }
        """.trimIndent())

        val currentDir = getCurrentDirectory()
        val pluginRoot = currentDir.parentFile.parentFile
        val pluginDirs = pluginRoot.listFiles(File::isDirectory)

        //FileUtils.copyDirectory(project.projectDir.parentFile)

        val build = GradleRunner.create()
                .withProjectDir(project.projectDir)
                .withGradleVersion(gmex.Versions.Gradle.WRAPPER)
                .forwardStdOutput(OutputStreamWriter(System.out))
                .forwardStdError(OutputStreamWriter(System.err))
                .withArguments("tasks")
                .withDebug(true) // github.com/gradle/gradle/issues/6862
                .build()

        //        val jarOutcome = build.task(":build")!!.outcome
        //        val installOutcome = build.task(":install")!!.outcome
        //        return isSuccess(jarOutcome, installOutcome)

        println(build.task("build")?.outcome)

        return true
    }

    private fun getCurrentDirectory() = File(".").absoluteFile

    private fun isSuccess(jarOutcome: TaskOutcome?,
                          installOutcome: TaskOutcome?) =
            isSuccess(jarOutcome) && isSuccess(installOutcome)

    private fun isSuccess(jarOutcome: TaskOutcome?) =
            jarOutcome == TaskOutcome.SUCCESS
}







