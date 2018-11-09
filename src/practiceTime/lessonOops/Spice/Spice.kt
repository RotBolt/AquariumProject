package practiceTime.lessonOops.Spice


//Making Spice a sealed class helps keep all the spices together in one file.
sealed class Spice(val name: String,
                   val spiciness: String = "mild",
                   open val spiceColor: SpiceColor) {
    private val heat: Int
        get() = when (spiciness) {
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "very spicy" -> 7
            "extremely spicy" -> 10
            else -> 0
        }

    abstract fun prepareSpice()

    interface SpiceColor {
        val color: Color
    }

}

class Curry(name: String, spiciness: String) : Spice(name, spiciness, spiceColor = YellowSpiceColor), Grinder {
    override fun grind() {
        println("Grinding for preparing curry")
    }

    override fun prepareSpice() {
        grind()
    }

    object YellowSpiceColor : SpiceColor {
        override val color = Color.YELLOW
    }
}

interface Grinder {
    fun grind()
}

enum class Color(rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00)
}

data class SpiceContainer(val spice: Spice) {
    val label = spice.name
}


fun main(args: Array<String>) {
    println(Curry("Nihari curry", "spicy").spiceColor.color)

    val mySpiceCabinet = listOf(
            SpiceContainer(Curry("Nihari curry", "spicy")),
            SpiceContainer(Curry("Fish Curry", "medium")),
            SpiceContainer(Curry("Butter Chicken Curry", "very spicy"))
    )

    for (container in mySpiceCabinet) println(container.label)

}