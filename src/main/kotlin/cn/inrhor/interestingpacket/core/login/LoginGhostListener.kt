package cn.inrhor.interestingpacket.core.login

import cn.inrhor.interestingpacket.InterestingPacket
import cn.inrhor.interestingpacket.PluginLoader
import cn.inrhor.interestingpacket.utils.MsgUtil
import fr.xephi.authme.events.LoginEvent
import io.izzel.taboolib.module.inject.TListener
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

@TListener(condition = "enable", depend = ["AuthMe"])
class LoginGhostListener : Listener {

    @EventHandler
    fun onJoin(ev : PlayerJoinEvent) {
        PluginLoader().ghostFactory().setGhost(ev.player, true)
    }

    /*
    ->
     注意，如果使用YUM重载本插件，那么还需要重载AuthMe插件
    ->
    */
    @EventHandler
    fun onLogin(ev : LoginEvent) {
        PluginLoader().ghostFactory().removePlayer(ev.player)
    }

    fun enable(): Boolean {
        return (InterestingPacket.config.getBoolean("login.ghost.enable"))
    }
}