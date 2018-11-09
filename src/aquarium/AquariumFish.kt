package aquarium

abstract class AquariumFish{
    abstract val color:String
}

class Shark() :AquariumFish(),FishEatAction{
    override fun eat() {
        println("hunt and eat fish")
    }

    override val color = "gray"
}

class Plecostomus():AquariumFish(),FishEatAction{
    override fun eat() {
        println("munch on algae")
    }

    override val color = "gold"
}

interface FishEatAction{
    fun eat()
}