package practiceTime.lessonOOps

class Spice(private val name: String, private val spiciness: String = "mild") {
    private val heat: Int
        get() = when(spiciness){
            "mild"->1
            "medium"->3
            "spicy"->5
            "very spicy"->7
            "extremely spicy"->10
            else ->0
        }

//    init {
//        println("Spice : ${this.name} spiciness : ${this.spiciness} ")
//    }

    companion object {
        private val mySpiceList = listOf(
                Spice("curry", "mild"),
                Spice("pepper", "medium"),
                Spice("cayenne", "spicy"),
                Spice("ginger", "mild"),
                Spice("red curry", "medium"),
                Spice("green curry", "mild"),
                Spice("hot pepper", "extremely spicy")
        )

        fun getSpicyList() = mySpiceList.filter { it.heat>5 }

        fun makeCommonSpice() = Spice("salt")
    }

}

fun main(args:Array<String>){
    println(Spice.getSpicyList())
    print(Spice.makeCommonSpice())
}