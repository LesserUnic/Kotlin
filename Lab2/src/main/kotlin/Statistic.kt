class Statistic {
    fun lines(list:MutableMap<Data, Int>){
        println("In work ${list.size} strings")
    }
    fun repeat(list: MutableMap<Data, Int>){
        println("Equals adresses")
        list.keys.forEach {
            println(it.city+" "+it.street+" "+it.house+" "+it.house+": ${list[it]}")
        }
        println("--------------------------------------------------")
    }
    fun floors(list:City){
        list.inp.keys.forEach {
            val floor = intArrayOf(0, 0, 0, 0, 0)
            val streets = list.inp[it]!!.inp.values
            streets.forEach {
                val houses=it.inp.values
                for(elem in houses){
                    floor[elem-1]++
                }
            }
            println(it+" 1:"+floor[0]+" 2:"+floor[1]+" 3:"+floor[2]+" 4:"+floor[3]+" 5:"+floor[4])
        }
    }
}