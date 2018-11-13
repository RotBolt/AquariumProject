package aquarium

fun main(args:Array<String>){
    val towerTank = TowerTank(TapWater())
    towerTank.addWater(TapWaterCleaner())
    println(towerTank.getWaterSupplyType()::class.simpleName)

    //out generic in BaseAquarium makes this line possible
    addItemTo(towerTank)
    // in makes this possible
    addCleaner(WaterCleaner())
}