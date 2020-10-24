package cn.inrhor.interestingpacket

import cn.inrhor.interestingpacket.core.login.LoginGhostListener
import cn.inrhor.interestingpacket.core.login.LoginLoadCore
import cn.inrhor.interestingpacket.core.login.LoginRandomListener
import cn.inrhor.interestingpacket.core.ping.PingInfo
import cn.inrhor.interestingpacket.core.ping.PingPacketListener
import com.yourpackage.utils.GhostFactory

class PluginLoader {

    companion object {
        var ghostFactory: GhostFactory? = null
        var pingInfo: PingInfo? = null
    }

    fun ghostFactory(): GhostFactory {
        return ghostFactory!!
    }

    fun pingInfo(): PingInfo {
        return pingInfo!!
    }

    fun init() {
        if (LoginRandomListener().enable()) {
            LoginLoadCore.load()
        }

        if (LoginGhostListener().enable()) {
            ghostFactory = GhostFactory(InterestingPacket.plugin)
        }

        val config = InterestingPacket.config
        if (config.getBoolean("motd.enable")) {
            pingInfo = PingInfo(
                config.getString("motd.icon"),
                config.getStringColored("motd.text.one"),
                config.getStringColored("motd.text.two"),
                config.getBoolean("motd.hideMember"))

            PingPacketListener().ping()
        }
    }

}