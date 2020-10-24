package cn.inrhor.interestingpacket.cmds

import cn.inrhor.interestingpacket.cmds.sub.SetCommand
import io.izzel.taboolib.module.command.base.*

@BaseCommand(name = "InterestingPacket", aliases = ["inter"])
class Command : BaseMainCommand() {
    @SubCommand(
        permission = "inter.randomlogin",
        type = CommandType.PLAYER)
    val randomLogin : BaseSubCommand = SetCommand()
}