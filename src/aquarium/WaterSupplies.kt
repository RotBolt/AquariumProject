package aquarium

open class WaterSupply(var needProcessed:Boolean)

class TapWater:WaterSupply(needProcessed = true){
    fun addChemicalCleaners(){
        needProcessed=false
    }
}

class LakeWater:WaterSupply(needProcessed = true){
    fun  filter(){
        needProcessed=false
    }
}

class FishStoreWater:WaterSupply(needProcessed = false)

interface Cleaner<in T:WaterSupply>{
    fun clean(waterSupply:T)
}

class WaterCleaner:Cleaner<WaterSupply>{
    override fun clean(waterSupply: WaterSupply) {

    }

}

class TapWaterCleaner:Cleaner<TapWater>{
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }

}