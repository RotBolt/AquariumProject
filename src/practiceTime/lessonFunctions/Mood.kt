package practiceTime.lessonFunctions


fun main(args: Array<String>) {
    println(whatShouldIDoToday("happy", "sunny"))
    println(whatShouldIDoToday("sad"))
    println(whatShouldIDoToday(getMood()))
}

fun getMood():String {
    print("How do ypu feel ? : ")
    return readLine()!!
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    return when {
        isHappySunny(mood, weather) -> "go for walk"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        isTooHot(temperature) -> "go swimming"
        else -> "Stay home and read"
    }
}

fun isTooHot(temperature: Int) = temperature > 35
fun isSadRainyCold(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun isHappySunny(mood: String, weather: String) = mood == "happy" && weather == "sunny"