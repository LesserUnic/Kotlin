
import java.io.File
import kotlin.time.TimeSource

fun main(args: Array<String>) {
    while(true) {
        val timeSource = TimeSource.Monotonic
        print("Enter path: ")
        val path = readln()
        //val path="D://Downloads/address.xml"
        if(File(path).exists()) {
            val temp: Reader = Reader(path)
            val type:String=path.slice(path.length - 3..path.length - 1)
            when(type){
                "xml"->{
                    val mark1 = timeSource.markNow()
                    temp.readXML()
                    val mark2 = timeSource.markNow()
                    Statistic().repeat(temp.repeat)
                    Statistic().floors(temp.mapList)
                    val mark3 = timeSource.markNow()
                    println("Uploading data: "+ (mark2 - mark1))
                    println("Analysing data: "+ (mark3 - mark2))
                }
                "csv"->{
                    val mark1 = timeSource.markNow()
                    temp.readCsv()
                    val mark2 = timeSource.markNow()
                    Statistic().repeat(temp.repeat)
                    Statistic().floors(temp.mapList)
                    val mark3 = timeSource.markNow()
                    println("Uploading data: "+ (mark2 - mark1))
                    println("Analysing data: "+ (mark3 - mark2))
                }
                else->{
                    println("Incorrect input file. Try again")
                }
            }
        }
        else{
            println("File doesn't exist. Try again")
        }

        println("\nNext try? Yes/No")
        val answer= readln()
        if(answer=="Yes"||answer=="yes"){
            continue
        }
        else{
            break
        }

    }
}