package cn.inrhor.interestingpacket.core.ping

import cn.inrhor.interestingpacket.InterestingPacket
import cn.inrhor.interestingpacket.PluginLoader
import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import com.comphenix.protocol.wrappers.WrappedServerPing
import java.io.File
import java.io.FileInputStream

class PingPacketListener {

    fun ping() {
        ProtocolLibrary.getProtocolManager().addPacketListener(object :
            PacketAdapter(InterestingPacket.plugin,
                ListenerPriority.NORMAL,
                PacketType.Status.Server.SERVER_INFO) {
            override fun onPacketSending(ev: PacketEvent) {
                val ping = ev.packet.serverPings.read(0)

                val pingInfo = PluginLoader().pingInfo()

                ping.setMotD(pingInfo.oneLine+"\n"+pingInfo.twoLine)
                ping.isPlayersVisible = !pingInfo.hideMember

                if (!pingInfo.iconIsNull()) {
                    val file = File(InterestingPacket.plugin.dataFolder,
                            pingInfo.icon+".png")
                    if (file.exists()) {
                        val stream = FileInputStream(file)
                        ping.favicon = WrappedServerPing.CompressedImage.fromPng(stream)
                        stream.close()
                    }
                }
            }
        })
    }
}