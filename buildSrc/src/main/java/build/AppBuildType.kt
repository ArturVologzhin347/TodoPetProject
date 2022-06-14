package build

import build.types.DEBUG
import build.types.RELEASE

interface AppBuildType {
    val name: String

    /** CI, testing, debug, etc **/
    val isDebuggable: Boolean

    /** JNI (Java Native Interface) debug for native C/C++ code **/
    val isJniDebuggable: Boolean

    /** Proguard. Recommended to use only in production builds **/
    val isMinifyEnabled: Boolean

    /** Recommended to use only in production builds **/
    val isShrinkResources: Boolean

    val applicationIdSuffix: String?

    val versionNameSuffix: String?

    companion object {
        val ALL = listOf(
            DEBUG,
            RELEASE
        )
    }
}
