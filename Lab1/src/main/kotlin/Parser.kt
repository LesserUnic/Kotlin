import java.net.URLEncoder

class Parser {
    private var request:String = ""

    fun request(){
        print("Enter searching request: ")
        request= readln()
        request=URLEncoder.encode(request, "UTF-8")
    }

    fun get_request():String{
        while(true) {
            request()
            if (request.isEmpty()) {
                println("Request is empty. Try again.")
            } else {
                break
            }
        }
        return "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=$request"
    }
}