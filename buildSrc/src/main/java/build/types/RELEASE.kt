package build.types

import build.AppBuildType

object RELEASE : AppBuildType {
    override val name: String = "release"
    override val isDebuggable: Boolean = false
    override val isJniDebuggable: Boolean = false
    override val isMinifyEnabled: Boolean = true
    override val isShrinkResources: Boolean = true
    override val applicationIdSuffix: String? = null
    override val versionNameSuffix: String? = null
}
