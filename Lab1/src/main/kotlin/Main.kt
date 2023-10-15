fun main() {
    while(true) {
        val wikiReq = Research(Parser().get_request())
        if(wikiReq.createListSearch()) {
            wikiReq.browse()
        }
        else{
            println("Not Found")
        }

        println("Next Browse\n Yes/No")
        var ans = readln()
        if(ans=="Yes" || ans =="yes"){
            continue
        } else{
          break
        }
    }
}
