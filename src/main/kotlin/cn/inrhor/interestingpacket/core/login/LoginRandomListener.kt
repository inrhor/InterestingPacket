package cn.inrhor.interestingpacket.core.login

import cn.inrhor.interestingpacket.InterestingPacket
import io.izzel.taboolib.module.inject.TListener
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

@TListener(condition = "enable")
class LoginRandomListener : Listener {

    @EventHandler
    fun onJoin(ev : PlayerJoinEvent) {
        // 随机登录
        LoginLoadCore.random(ev.player)
    }

    fun enable(): Boolean {
        return (InterestingPacket.config.getBoolean("login.random.enable"))
    }
}