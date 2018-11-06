package practiceTime.lessonFunctions

import java.util.*

fun main(args: Array<String>) {
    print(gamePlay(rollDice2(6)))
}

val rollDice = { sides: Int ->
    if (sides == 0) 0 else Random().nextInt(sides) + 1
}

val rollDice2: (Int) -> Int = { sides ->
    if (sides == 0) 0 else Random().nextInt(sides) + 1
}

fun gamePlay(diceRoll:Int){
    print(diceRoll)
}