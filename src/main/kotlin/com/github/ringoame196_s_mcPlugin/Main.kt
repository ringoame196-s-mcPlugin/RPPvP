package com.github.ringoame196_s_mcPlugin

import com.github.ringoame196_s_mcPlugin.commands.Command
import com.github.ringoame196_s_mcPlugin.commands.TabCompleter
import com.github.ringoame196_s_mcPlugin.events.BackStep
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        super.onEnable()
        saveDefaultConfig()

        Data.max = config.getInt("max")
        Data.coolTimeMax = config.getInt("cool_time")
        Data.knockBack = config.getDouble("knock_back")

        val plugin = this
        server.pluginManager.registerEvents(BackStep(plugin), plugin)
        val command = getCommand("rppvp")
        command!!.setExecutor(Command(plugin))
        command.tabCompleter = TabCompleter()
    }
}
