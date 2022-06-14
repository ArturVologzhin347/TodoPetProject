package dependency

data class Dependency(val notation: String, val version: String) {

    operator fun invoke(): String {
        return "$notation:$version"
    }
}
