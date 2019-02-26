package gmex

import org.gradle.api.JavaVersion

/**
 * @author Michael Chalabine
 */

object Versions {

    object Java {
        val TARGET_JVM = JavaVersion.VERSION_1_8.toString()
    }

    object Gradle {
        const val WRAPPER = "5.2.1"
    }

    object Plugin {
        const val KOTLIN = "1.3.11"
    }

    object Test {
        const val JUNIT = "5.4.0"
    }

    object Mock {
        const val MOCK_K = "1.9"
    }

}

