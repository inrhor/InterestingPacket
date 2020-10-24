package cn.inrhor.interestingpacket.cmds.sub

import cn.inrhor.interestingpacket.core.login.LoginLoadCore
import cn.inrhor.interestingpacket.utils.Check
import io.izzel.taboolib.module.command.base.Argument
import io.izzel.taboolib.module.command.base.BaseSubCommand
import io.izzel.taboolib.module.locale.TLocale
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SetCommand : BaseSubCommand() {
    override fun getDescription(): String {
        return TLocale.asString("COMMAND_DESCRIPTION.RANDOMLOGIN_SET")
    }

    override fun getArguments() = arrayOf(
        Argument(TLocale.asString("COMMAND_DESCRIPTION.VAR.POST_INT"), true))

    override fun onCommand(sender: CommandSender, command: Command, label : String, args: Array<out String>) {

        if (!Check.isNumber(args[0])) {
            TLocale.sendTo(sender, "POST_INT")
            return
        }

        val addR = args[0].toInt()

        val player : Player = sender as Player

        LoginLoadCore.set(player, addR)

        TLocale.sendTo(sender, "RANDOMLOGIN_SET", addR)
    }
}