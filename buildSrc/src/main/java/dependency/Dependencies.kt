package dependency

import extensions.version

object Dependencies {
    val CORE_KTX = Notation.CORE_KTX version Version.CORE_KTX
    val LIFECYCLE_RUNTIME = Notation.LIFECYCLE_RUNTIME version Version.LIFECYCLE_RUNTIME

    val COMPOSE_UI = Notation.COMPOSE_UI version Version.COMPOSE
    val COMPOSE_MATERIAL = Notation.COMPOSE_MATERIAL version Version.COMPOSE
    val COMPOSE_PREVIEW = Notation.COMPOSE_PREVIEW version Version.COMPOSE
    val COMPOSE_ACTIVITY = Notation.COMPOSE_ACTIVITY version Version.COMPOSE_ACTIVITY

    val STRICT = Notation.STRICT version Version.STRICT
    val STRICT_KTX = Notation.STRICT_KTX version Version.STRICT

    object Test {
        val JUNIT = Notation.JUNIT version Version.JUNIT
    }

    object AndroidTest {
        val JUNIT_EXT = Notation.JUNIT_EXT version Version.JUNIT_EXT
        val ESPRESSO_CORE = Notation.ESPRESSO_CORE version Version.ESPRESSO_CORE
        val JUNIT_COMPOSE = Notation.JUNIT_COMPOSE version Version.COMPOSE
    }

    object Debug {
        val COMPOSE_TOOLING = Notation.COMPOSE_TOOLING version Version.COMPOSE
        val COMPOSE_MANIFEST = Notation.COMPOSE_MANIFEST version Version.COMPOSE
    }
}
