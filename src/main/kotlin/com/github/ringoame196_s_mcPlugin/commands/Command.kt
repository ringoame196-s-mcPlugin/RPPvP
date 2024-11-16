package com.github.ringoame196_s_mcPlugin.commands

import com.github.ringoame196_s_mcPlugin.Data
import com.github.ringoame196_s_mcPlugin.YmlFileManager
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.Plugin
import java.io.File

class Command(private val plugin: Plugin) : CommandExecutor {
    private val ymlFileManager = YmlFileManager()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) return false
        val subCommand = args[0]

        when (subCommand) {
            CommandConst.RELOAD_CONFIG_COMMAND -> reloadConfigCommand(sender)
        }
        return true
    }

    private fun reloadConfigCommand(sender: CommandSender) {
        try {
            val configFile = File(plugin.dataFolder, "config.yml")
            Data.max = ymlFileManager.acquisitionIntValue(configFile, "max")
            Data.coolTimeMax = ymlFileManager.acquisitionIntValue(configFile, "cool_time")
            Data.knockBack = ymlFileManager.acquisitionDoubleValue(configFile, "knock_back")
        } catch (e: Exception) {
            sender.sendMessage("${ChatColor.RED}Configのリロード中にエラーが発生しました: ${e.message}")
        }

        val message = "${ChatColor.GOLD}configをリロードしました"
        sender.sendMessage(message)
    }
}
