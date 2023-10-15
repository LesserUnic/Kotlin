import kotlin.time.TimeSource

fun main(args: Array<String>) {
    val timeSource = TimeSource.Monotonic
    val mark1 = timeSource.markNow()
    val path="D://Downloads/address.csv"
    val temp=Reader(path)
    val info=temp.readCsv()
    val mark2 = timeSource.markNow()
    Statistic().statistic(info)
    println(info["Барнаул"])
    val mark3 = timeSource.markNow()
    println(mark2-mark1)
    println(mark3-mark2)
}