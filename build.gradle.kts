plugins {
    kotlin("js") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
}

group = "org.alliander"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

fun kotlinw(target: String, version: String): String = "org.jetbrains.kotlin-wrappers:kotlin-$target:$version"
fun kotlinx(target: String, version: String): String = "org.jetbrains.kotlinx:kotlinx-$target:$version"

dependencies {
    // Wrappers
    implementation(npm("react", "18.2.0"))
    implementation(npm("react-is", "18.2.0"))
    implementation(npm("react-dom", "18.2.0"))
    implementation(npm("react-router-dom", "6.2.1"))
    implementation(npm("styled-components", "~5.3.3"))
    implementation(kotlinw("react", "18.2.0-pre.359"))
    implementation(kotlinw("react-dom", "18.2.0-pre.359"))
    implementation(kotlinw("react-router-dom", "6.3.0-pre.359"))
    implementation(kotlinw("styled", "5.3.5-pre.359"))

    // Webpack
    implementation(npm("css-loader", "6.7.1"))
    implementation(npm("style-loader", "3.3.1"))

    // External libraries
    implementation(npm("awesome-notifications", "3.1.3"))

    // Kotlin
    implementation(kotlinx("coroutines-core", "1.6.4"))
    implementation(kotlinx("serialization-json", "1.3.3"))

    // Test
    testImplementation(kotlin("test", "1.6.0"))
}

// We are using the LEGACY compiler as the IR compiler is currently slower.
kotlin {
    js(LEGACY) {
        browser {
            commonWebpackConfig {
                configDirectory = File("./webpack")
            }
        }
        binaries.executable()
    }
}

kotlin.sourceSets.all {
    languageSettings.optIn("kotlin.RequiresOptIn")
}
