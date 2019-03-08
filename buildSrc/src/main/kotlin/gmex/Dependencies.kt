package gmex

/**
 * @author Michael Chalabine
 */

object Dependencies {

    object Plugin {
        val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Plugin.KOTLIN}"
    }

    object Kotlin {
        val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Plugin.KOTLIN}"
    }

    object Test {
        val JUNIT_API = "org.junit.jupiter:junit-jupiter-api:${Versions.Test.JUNIT}"
        val JUNIT_ENGINE = "org.junit.jupiter:junit-jupiter-engine:${Versions.Test.JUNIT}"
        val JUNIT_SUPPORT = "org.junit.jupiter:junit-jupiter-migrationsupport:${Versions.Test.JUNIT}"
        val JUNIT_RUNNER = "org.junit.jupiter:junit-platform-runner:${Versions.Test.JUNIT}"
        val JUNIT_PARAMS = "org.junit.jupiter:junit-jupiter-params:${Versions.Test.JUNIT}"
    }

    object Mock {
        val MOCK_K = "io.mockk:mockk:${Versions.Mock.MOCK_K}"
    }

    object Spring {
        val DEPENDENCY_MANAGEMENT =
                "io.spring.gradle:dependency-management-plugin:${Versions.Spring.DEPENDENCY_MANAGEMENT}"
    }
}

