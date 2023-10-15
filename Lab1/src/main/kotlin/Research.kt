import com.google.gson.Gson
import java.awt.Desktop.getDesktop
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL

class Research(val url : String) {
    private var Results: List<Search> = listOf()

    fun createListSearch():Boolean {
        val json=URL(url).openConnection() as HttpURLConnection
        Results=(Gson().fromJson(json.inputStream.bufferedReader().readText(), JSON::class.java)).query.search
        println("List of possible requests:")
        for (current in Results.indices) {
            println("${current + 1}: ${Results[current].title}")
        }
        if (Results.size>0){
            return true
        }
        return false
    }
    fun browse() {
        while(true) {
            print("Input number of articles to browse: ")
            val answer = readln()
            if(answer!=""){
                val userAnswer: Int = answer?.toInt()!!
                if (userAnswer > 0 && userAnswer <= Results.size) {
                    getDesktop()
                        .browse(
                            URI(
                                "https://ru.wikipedia.org/w/index.php?curid=${
                                    Results[
                                        userAnswer - 1].pageid
                                }"
                            )
                        )
                    break
                } else {
                    println("Incorrect input")
                }
            }
            else{
                println("Incorrect input")
            }
        }
    }
}