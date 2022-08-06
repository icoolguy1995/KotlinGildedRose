package guru.drako.examples.gildedrose

class Shop(val items: List<Item>) {


  fun updateQuality() {
    for (item in items)
      checkQuality(item)
  }

  private fun checkQuality(item: Item){
    when (item.name) {
      "Sulfuras, Hand of Ragnaros"->{
        return
      }

      "Backstage passes to a TAFKAL80ETC concert" -> {
        handleBackStage(item)
      }

      "Aged Brie" -> {
        increaseQuality(item)
      }

      else -> {
        decreaseQuality(item)
      }
    }
    --item.sellIn

    if (degradeQualityTwice(item)) {
      decreaseQuality(item)
    }
  }

  private fun handleBackStage(item: Item) {
    if (item.sellIn > 0) {
      if (item.sellIn < 6 && item.quality < 48) {
        increaseQuality(item,3)
      } else if (item.sellIn < 11 && item.quality < 49) {
        increaseQuality(item,2)
      } else {
        increaseQuality(item)
      }
    } else {
      item.quality = 0
    }
  }



  private fun degradeQualityTwice(item: Item): Boolean {
    return item.sellIn < 0
  }

  private fun decreaseQuality(item: Item) {
    when (item.name) {
      "Conjured Mana Cake" -> {
        if (item.quality > 1) {
          item.quality -= 2
        } else
          item.quality = 0
      }

      "Aged Brie" -> {
        //ignore ;)
      }

      else -> {
        if (item.quality > 0)
          item.quality--
      }
    }
  }


  private fun increaseQuality(item:Item, by:Int = 1){
    if(item.quality <50)
      item.quality+=by
  }

}
