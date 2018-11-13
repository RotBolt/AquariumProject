package aquarium

import kotlin.math.PI

open class BaseAquarium<out T:WaterSupply>(
        protected var length: Int = 100,
        protected var width: Int = 20,
        protected var height: Int = 40,
        val waterSupply: T ) {
    open var volume: Int
        get() = (length * width * height) / 1000
        set(value) {
            height = (value * 1000) / (length * width)
        }

    open var waterCapacity = volume * 0.9



    fun getWaterSupplyType() = waterSupply

    fun addWater(cleaner:Cleaner<T>){
        if (waterSupply.needProcessed) cleaner.clean(waterSupply)

        println("adding water from ${waterSupply::class.simpleName}")
    }

    constructor(numberOfFish: Int) : this(waterSupply = (FishStoreWater() as T)) {
        val waterRequired = numberOfFish * 2000 //cm3
        val tankSize = waterRequired + (waterRequired * 0.1)
        height = ((tankSize) / (length * width)).toInt()
    }
}

fun addItemTo(aquarium: BaseAquarium<WaterSupply>){}

fun addCleaner(cleaner: Cleaner<TapWater>){}


// reified makes the R real to be checked on Run Time. "is" checked on runtime
// Generics are erased on runtime
inline fun<reified R:WaterSupply> BaseAquarium<*>.hasWaterSupplyOfType() = waterSupply is R

class TowerTank<T:WaterSupply>(val towerTankWater:T) : BaseAquarium<T>(waterSupply = towerTankWater) {
    override var volume: Int
        get() = ((PI * length * width * height) / 1000).toInt()
        set(value) {
            height = (value * 1000) / (length * width)
        }

    override var waterCapacity = volume * 0.8
}