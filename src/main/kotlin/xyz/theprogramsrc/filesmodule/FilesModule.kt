package xyz.theprogramsrc.filesmodule

import xyz.theprogramsrc.simplecoreapi.global.models.module.Module
import xyz.theprogramsrc.simplecoreapi.global.models.module.ModuleDescription

class FilesModule: Module {

    override val description: ModuleDescription =
        ModuleDescription(
            name = "@name@",
            version = "@version@",
            authors = listOf("Im-Fran")
        )

    override fun onDisable() {
        TODO("Not yet implemented")
    }

    override fun onEnable() {
        TODO("Not yet implemented")
    }
}