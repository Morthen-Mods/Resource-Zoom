plugins {
    id("net.morthen.gradle.multiloader")
}

multiloader {
    loader = "forge"

    forgeVersion = providers.gradleProperty("forge")
    forgeMixins = listOf(
        "${ modId.get() }.mixins.json"
    )

    withModPublish {
        server = false
    }

    applyMetadataReplacements(listOf("pack.mcmeta", "META-INF/mods.toml"), mapOf(
        "forge_version" to forgeVersion.get(),
        "issues_url" to providers.gradleProperty("issues_url")
    ))
}