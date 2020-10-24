package cn.inrhor.interestingpacket.core.ping

class PingInfo(
        var icon: String?,
        var oneLine: String?, var twoLine: String?,
        var hideMember: Boolean) {

    fun iconIsNull(): Boolean {
        return (icon == null)
    }
}