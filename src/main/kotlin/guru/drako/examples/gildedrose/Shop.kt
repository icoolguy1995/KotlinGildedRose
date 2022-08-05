package guru.drako.examples.gildedrose

class Shop(val items: List<Item>) {


  private fun checkQuality(item: Item){
    if(item.quality !in 0..50)
      return

    when (item.name) {
      "Backstage passes to a TAFKAL80ETC concert" -> {
        handleBackStage(item)
      }
      "Aged Brie" -> {
        ++item.quality
      }
      "Conjured Mana Cake" -> {
        decreaseQuality(item)
      }
      else ->{
        decreaseQuality(item)
      }
    }
    --item.sellIn

    if(degradeQualityTwice(item)) {
      decreaseQuality(item)
    }
  }

  private fun handleBackStage(item: Item){
    if(item.sellIn >0){
        if (item.sellIn < 6 && item.quality<48) {
          item.quality += 3
        } else if (item.sellIn < 11 && item.quality<49) {
          item.quality += 2
        } else {
          ++item.quality
        }
    }else {
      item.quality = 0
    }
  }

  fun updateQuality() {
    for (item in items)
      checkQuality(item)
  }

  private fun degradeQualityTwice(item: Item) : Boolean{
    return item.sellIn<0&&item.quality>0
  }

  private fun decreaseQuality(item: Item){
      --item.quality
    if (item.name == "Conjured Mana Cake" && item.quality>0){
      --item.quality
    }
  }
}
