package cn.inrhor.interestingpacket.core.login

import cn.inrhor.interestingpacket.InterestingPacket
import org.bukkit.Location
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player

object LoginLoadCore {
    var centerLoc : Location? = null
    var addR : Int? = null

    fun set(player: Player, addR : Int) {
        centerLoc = player.location
        this.addR = addR
        save()
    }

    fun save() {
        val config : YamlConfiguration = InterestingPacket.config
        config.set("login.random.data.center", centerLoc)
        config.set("login.random.data.addR", addR)
        InterestingPacket.config.saveToFile()
    }

    fun load() {
        val config : YamlConfiguration = InterestingPacket.config
        centerLoc = config.getLocation("login.random.data.center")
        addR = config.getInt("login.random.data.addR")
    }

    fun random(player: Player) {
        val randomX = (-addR!!..addR!!).random().toDouble()
        val randomZ = (-addR!!..addR!!).random().toDouble()
        centerLoc?.add(randomX, 0.0, randomZ)?.let { player.teleport(it) }
    }
}