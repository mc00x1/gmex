package gmex

import io.spring.gradle.dependencymanagement.dsl.DependenciesHandler
import io.spring.gradle.dependencymanagement.internal.bridge.InternalComponents
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginConvention
import java.nio.file.Path

/**
 * @author Michael Chalabine
 */
class DependencyManagementPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val projectRoot : Path = getTestProjectsDirectoryPath(project)
        BuildSupport.getTestProjectsDirectories(projectRoot)
//        TODO("not implemented")
    }

    private fun getTestProjectsDirectoryPath(project: Project): Path {
        val springPluginComponents = InternalComponents(project)
        val plugin = project.convention.getPlugin(JavaPluginConvention::class.java)
        val sourceSet = plugin.sourceSets.findByName("testProjects")
        val srcDirs = sourceSet?.allSource?.srcDirs
        val testProjectsDir= srcDirs?.first()
        return testProjectsDir!!.toPath()
    }

}