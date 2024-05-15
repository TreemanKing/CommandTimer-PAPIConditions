plugins {
    id("java")
}

group = "com.github.treemanking"
version = "1.0.0"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()
    mavenLocal()

    maven("https://www.jitpack.io")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

dependencies {
    implementation("org.jeasy:easy-rules-core:4.1.0")
    implementation("com.github.titivermeesch:CommandTimer:8.6.0")
    compileOnly("org.spigotmc:spigot-api:1.13.1-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains:annotations:23.1.0")
    compileOnly("me.clip:placeholderapi:2.11.5")

}
