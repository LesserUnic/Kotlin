import java.io.FileInputStream


class Reader (private val path:String){
    private val inputStream = FileInputStream(path)
    private val mapList = mutableMapOf< String, List<Info> >()
    fun readCsv(): MutableMap<String, List<Info>>{
        val reader = inputStream.bufferedReader()
        val header = reader.readLine()
        for (line in reader.lineSequence().filter { it.isNotBlank() }){
            val (city, street, house, floor) = line.split(';', ignoreCase = false, limit = 4)
            val key = city.trim().removeSurrounding("\"").toString()
            val temp = Info(street.trim().removeSurrounding("\"").toString(),
                house.trim().toInt(),
                floor.trim().toInt()
            )
            if(mapList[key].isNullOrEmpty()){
                mapList.put(key, listOf(temp))
            }
            else{
                //println(tempList!!.last)
                //mapList.remove(key)
                mapList.put(key, mapList[key]!!.plus(temp))
                //println(mapList[key]!!.last)
            }
        }
        return mapList
    }
}