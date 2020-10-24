package cn.inrhor.interestingpacket.utils

import org.bukkit.Bukkit
import org.bukkit.command.CommandSender

object MsgUtil {
    const val tag = "§7§l[ §c§l§ki §7§l]§r "

    fun send(msg : String) {
        Bukkit.getConsoleSender().sendMessage(msg.replace("&", "§"))
    }

    fun send(sender: CommandSender, msg: String) {
        sender.sendMessage(msg.replace("&", "§"))
    }
}