package practiceTime.lessonOops.Spice

class SpiceDemoClass(private val name: String, private val spiciness: String = "mild") {
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
//        println("SpiceDemoClass : ${this.name} spiciness : ${this.spiciness} ")
//    }

    companion object {
        private val mySpiceList = listOf(
                SpiceDemoClass("curry", "mild"),
                SpiceDemoClass("pepper", "medium"),
                SpiceDemoClass("cayenne", "spicy"),
                SpiceDemoClass("ginger", "mild"),
                SpiceDemoClass("red curry", "medium"),
                SpiceDemoClass("green curry", "mild"),
                SpiceDemoClass("hot pepper", "extremely spicy")
        )

        fun getSpicyList() = mySpiceList.filter { it.heat>5 }

        fun makeCommonSpice() = SpiceDemoClass("salt")
    }

}

fun main(args:Array<String>){
    println(SpiceDemoClass.getSpicyList())
    print(SpiceDemoClass.makeCommonSpice())
}