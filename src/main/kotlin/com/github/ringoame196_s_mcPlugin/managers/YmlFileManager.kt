package com.github.ringoame196_s_mcPlugin.managers

import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class YmlFileManager {
    private fun acquisitionYml(file: File): YamlConfiguration {
        return YamlConfiguration.loadConfiguration(file)
    }

    fun acquisitionIntValue(file: File, key: String): Int {
        val ymlFile = acquisitionYml(file)
        return ymlFile.getInt(key)
    }

    fun acquisitionDoubleValue(file: File, key: String): Double {
        val ymlFile = acquisitionYml(file)
        return ymlFile.getDouble(key)
    }

    fun acquisitionListValue(file: File, key: String): MutableList<String> {
        val ymlFile = acquisitionYml(file)
        return ymlFile.getStringList(key)
    }

    fun setValue(file: File, key: String, value: Any?) {
        val ymlFile = acquisitionYml(file)
        ymlFile.set(key, value)
        ymlFile.save(file)
    }
}
