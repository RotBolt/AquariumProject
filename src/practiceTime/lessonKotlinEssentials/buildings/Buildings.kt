package practiceTime.lessonKotlinEssentials.buildings

open class BaseBuildingMaterial(){
    open val numberNeeded=1
}

class Wood:BaseBuildingMaterial(){
    override val numberNeeded = 4
}

class Brick:BaseBuildingMaterial(){
    override val numberNeeded = 8
}


class Building<out T:BaseBuildingMaterial>(val buildingMaterial: T){
    val baseMaterialsNeeded=100

    val actualMaterialsNeeded= buildingMaterial.numberNeeded*baseMaterialsNeeded

    fun build(){
        println("$actualMaterialsNeeded ${buildingMaterial::class.simpleName}s required")
    }
}

fun <T:BaseBuildingMaterial> isSmallBuilding(building: Building<T>){
    if (building.actualMaterialsNeeded<500) println("Small Building")
    else println("Biggie Building")
}
fun main(args:Array<String>){
    val woodenBuilding = Building(Wood())
    woodenBuilding.build()
    isSmallBuilding(woodenBuilding)
}