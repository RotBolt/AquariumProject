package practiceTime.lessonFunctions


fun main(pui: Array<String>) {

    println(filterCurry(spices))
    println(filterSpices(spices))
    println(takeFirstThree(spices))
}

fun filterCurry(list: List<String>): List<String> {
    return list.filter { it.contains("curry") }.sortedBy { it.length }
}
val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

fun filterSpices(list: List<String>) = list.filter { it.startsWith('c') && it.endsWith('e') }

fun takeFirstThree(list: List<String>) = list.take(3).filter { it.startsWith('c') }