package practiceTime.lessonFunctions




fun main(args: Array<String>) {
    for (i in 1..10) {
        val fortune = getFortuneCookie(getBirthday())
        println("Your fortune is : $fortune")
        if (fortune.contains("Take it easy")) break
    }
}


fun getBirthday(): Int {
    print("Enter your birthday ")
    return readLine()?.toIntOrNull() ?: 1
}

fun getFortuneCookie(bday: Int): String {
    val list = listOf(
            "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune."
    )

    val fortuneIndex = when (bday) {
        in 1..7 -> 4
        28, 31 -> 2
        else -> bday.rem(list.size)
    }

    return list[fortuneIndex]
}
