package aquarium

import kotlin.math.PI

open class BaseAquarium(protected var length: Int = 100, protected var width: Int = 20, protected var height: Int = 40) {
    open var volume: Int
        get() = (length * width * height) / 1000
        set(value) {
            height = (value * 1000) / (length * width)
        }

    open var waterCapacity = volume * 0.9

    constructor(numberOfFish: Int) : this() {
        val waterRequired = numberOfFish * 2000 //cm3
        val tankSize = waterRequired + (waterRequired * 0.1)
        height = ((tankSize) / (length * width)).toInt()
    }

}

class TowerTank : BaseAquarium() {
    override var volume: Int
        get() = ((PI * length * width * height) / 1000).toInt()
        set(value) {
            height = (value * 1000) / (length * width)
        }

    override var waterCapacity = volume * 0.8
}