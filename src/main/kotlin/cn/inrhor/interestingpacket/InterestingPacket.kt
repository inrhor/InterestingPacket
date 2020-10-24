package cn.inrhor.interestingpacket

import io.izzel.taboolib.loader.Plugin
import io.izzel.taboolib.module.config.TConfig
import io.izzel.taboolib.module.inject.TInject

object InterestingPacket : Plugin() {
    @TInject(locale = "setting.lang")
    lateinit var config : TConfig

    @TInject(state = TInject.State.STARTING, init = "init")
    lateinit var loader : PluginLoader

}