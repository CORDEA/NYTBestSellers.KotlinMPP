object Deps {
    private val kotlin_version = "1.3.30-eap-11"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    val kotlin_serialization = "org.jetbrains.kotlin:kotlin-serialization:$kotlin_version"

    private val ktor_version = "1.1.4"
    val ktor_client_core = "io.ktor:ktor-client-core:$ktor_version"
    val ktor_client_json = "io.ktor:ktor-client-json:$ktor_version"
    val ktor_client_core_jvm = "io.ktor:ktor-client-core-jvm:$ktor_version"
    val ktor_client_json_jvm = "io.ktor:ktor-client-json-jvm:$ktor_version"
    val ktor_client_android = "io.ktor:ktor-client-android:$ktor_version"

    private val coroutines_version = "1.2.0"
    val coroutines_core_common = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutines_version"
    val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"

    private val serialization_version = "0.11.0"
    val serialization_runtime_common =
        "org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$serialization_version"
    val serialization_runtime =
        "org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serialization_version"

    private val koin_version = "2.0.0-rc-2"
    val koin_core = "org.koin:koin-core:$koin_version"
    val koin_core_ext = "org.koin:koin-core-ext:$koin_version"
    val koin_android = "org.koin:koin-android:$koin_version"
    val koin_android_scope = "org.koin:koin-android-scope:$koin_version"

    private val groupie_version = "2.3.0"
    val groupie = "com.xwray:groupie:$groupie_version"
    val groupie_extensions = "com.xwray:groupie-kotlin-android-extensions:$groupie_version"
    val groupie_databinding = "com.xwray:groupie-databinding:$groupie_version"
}
