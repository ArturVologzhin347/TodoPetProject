package build.types

import build.AppBuildType

object DEBUG : AppBuildType {
    override val name: String = "debug"
    override val isDebuggable: Boolean = true
    override val isJniDebuggable: Boolean = true
    override val isMinifyEnabled: Boolean = false
    override val isShrinkResources: Boolean = false
    override val applicationIdSuffix: String = ".develop"
    override val versionNameSuffix: String = "-debug"
}
