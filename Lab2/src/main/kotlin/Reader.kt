import java.io.FileInputStream


class Reader (private val path:String){
    private val inputStream = FileInputStream(path)
    val mapList = City()
    var repeat= mutableMapOf<Data, Int>()

    fun checkRepeat(key:Data){
        if(repeat.containsKey(key)){
            repeat[key]=repeat[key]!!+1
        }
        else{
            repeat[key]=0
        }
    }
    fun putMap(city:String, street:String, house:Int, floor:Int){
        if(!mapList.inp.containsKey(city)){
            mapList.inp.put(city, Street())
            mapList.inp[city]!!.inp.put(street, House())
            mapList.inp[city]!!.inp[street]!!.inp.put(house, floor)
        }
        else{
            if(!mapList.inp[city]!!.inp.containsKey(street)){
                mapList.inp[city]!!.inp.put(street, House())
                mapList.inp[city]!!.inp[street]!!.inp.put(house, floor)
            }
            else{
                if(!mapList.inp[city]!!.inp[street]!!.inp.containsKey(house)){
                    mapList.inp[city]!!.inp[street]!!.inp.put(house, floor)
                }
                else{
                    if(mapList.inp[city]!!.inp[street]!!.inp[house] == floor){
                        checkRepeat(Data(city, street, house, floor))
                    }
                }
            }
        }
    }
    fun readCsv(){
        val reader = inputStream.bufferedReader()
        reader.readLine()
        for (line in reader.lineSequence().filter { it.isNotBlank() }){
            var (city, street, house, floor) = line.split(';', ignoreCase = false, limit = 4)
            city = city.trim().removeSurrounding("\"").toString()
            street=street.trim().removeSurrounding("\"").toString()
            putMap(city, street, house.trim().toInt(), floor.trim().toInt())
        }

    }

    fun readXML(){
        val reader = inputStream.bufferedReader()

        for (line in reader.lineSequence().filter { it.isNotBlank() }){
            val temp=line.split('"', ignoreCase = false, limit = 9)

            if(temp.size==9) {
                var (city, street, house, floor) = temp.slice(1..temp.size - 1 step 2)

                city = city.trim().removeSurrounding("\"").toString()
                street = street.trim().removeSurrounding("\"").toString()
                putMap(city, street, house.trim().toInt(), floor.trim().toInt())
            }
        }
    }
}