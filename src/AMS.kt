import java.util.*

fun main(args: Array<String>) {
    feedTheFish()
}

fun feedTheFish() {
    val day = getDay()
    val fishFood = getFishFood(day)
    println("Today is $day and the fish eat $fishFood")

    if (shouldChangeWater(day, temperature = 34, dirtyPercent = 30)) {
        println("Change the water today")
    }


}

fun getFishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Thursday" -> "red worms"
        "Friday" -> "plankton"
        "Saturday" -> "granules"
        else -> "fasting"
    }
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, newFishSize: Int = 2, hasDecor: Boolean = true): Boolean {
    return (tankSize * (if (hasDecor) 0.8 else 1.0) >= (currentFish.sum() + newFishSize))
}


fun getDirtySensorReading() = 20

// Default parameters are determined during call time . Proceed with caution
fun shouldChangeWater(day: String, temperature: Int = 22, dirtyPercent: Int = getDirtySensorReading()): Boolean {
    return when {
        isTooHot(temperature) -> true
        isSunday(day) -> true
        isToDirty(dirtyPercent) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30
fun isToDirty(dirtyPercent: Int) = dirtyPercent > 30
fun isSunday(day: String) = day == "Sunday"

fun getDay(): String {
    val days = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    return days[Random().nextInt(7)]
}

