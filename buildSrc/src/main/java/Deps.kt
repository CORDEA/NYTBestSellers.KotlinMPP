object Deps {
    private val kotlin_version = "1.3.30-eap-11"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"

    private val ktor_version = "1.1.3"
    val ktor_client_core = "io.ktor:ktor-client-core:$ktor_version"
    val ktor_client_json = "io.ktor:ktor-client-json:$ktor_version"

    private val coroutines_version = "1.2.0"
    val coroutines_core_common = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutines_version"

    private val serialization_version = "0.11.0"
    val serialization_runtime_common =
        "org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$serialization_version"
}
