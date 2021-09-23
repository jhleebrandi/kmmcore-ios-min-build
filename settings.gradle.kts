pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "KmmMami"
include(":androidApp")
include(":shared")
include(":core_engine")
include(":login-ui")
include(":tracker")
