package cn.inrhor.interestingpacket

import cn.inrhor.interestingpacket.core.login.LoginGhostListener
import cn.inrhor.interestingpacket.core.login.LoginLoadCore
import cn.inrhor.interestingpacket.core.login.LoginRandomListener
import com.yourpackage.utils.GhostFactory

class PluginLoader {

    companion object {
        var ghostFactory: GhostFactory? = null
    }

    fun ghostFactory(): GhostFactory {
        return ghostFactory!!
    }

    fun init() {
        if (LoginRandomListener().enable()) {
            LoginLoadCore.load()
        }

        if (LoginGhostListener().enable()) {
            ghostFactory = GhostFactory(InterestingPacket.plugin)
        }
    }

}