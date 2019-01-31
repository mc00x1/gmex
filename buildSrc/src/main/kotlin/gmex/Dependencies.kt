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
        val JUNIT_COMPILE = "org.junit.jupiter:junit-jupiter-api:${Versions.Test.JUNIT}"
        val JUNIT_RUNTIME = "org.junit.jupiter:junit-jupiter-engine:${Versions.Test.JUNIT}"
    }

    object Mock {
        val MOCK_K = "io.mockk:mockk:${Versions.Mock.MOCK_K}"
    }
}

