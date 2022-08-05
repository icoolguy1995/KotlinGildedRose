package guru.drako.examples.gildedrose

class Shop(val items: List<Item>) {

  fun updateInventory(){
    for (item in items) {
      when(item.name){
        "Backstage passes to a TAFKAL80ETC concert"->{
          if(item.sellIn >0 && item.quality <50){
            if(item.sellIn <6 ){
              item.quality+=3
            } else if (item.sellIn <11){
              item.quality+=2
            }else{
              item.quality++
            }
          }else if(item.sellIn <0){
            item.quality = 0
          }
        }
        "Aged Brie"->{
          if(item.quality<50)
            item.quality++
        }
        "Sulfuras, Hand of Ragnaros"->{
          //do nothing for the iteration ;)
        }
        "Conjured Mana Cake"->{
          if(item.quality>1){
            item.quality -=2
          }else if(item.quality ==1){
            item.quality = 0
          }
        }
        else->{
          if(item.quality >0){
            item.quality--
          }
        }

      }
    }
  }

  fun updateQuality() {
    for (item in items) {
      if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
        if (item.quality > 0) {
          if (item.name != "Sulfuras, Hand of Ragnaros") {
            --item.quality
          }
        }
      } else {
        if (item.quality < 50) {
          ++item.quality

          if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            if (item.sellIn < 11) {
              if (item.quality < 50) {
                ++item.quality
              }
            }

            if (item.sellIn < 6) {
              if (item.quality < 50) {
                ++item.quality
              }
            }
          }
        }
      }

      if (item.name != "Sulfuras, Hand of Ragnaros") {
        --item.sellIn
      }

      if (item.sellIn < 0) {
        if (item.name != "Aged Brie") {
          if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
            if (item.quality > 0) {
              if (item.name != "Sulfuras, Hand of Ragnaros") {
                --item.quality
              }
            }
          } else {
            item.quality -= item.quality
          }
        } else {
          if (item.quality < 50) {
            ++item.quality
          }
        }
      }
    }
  }
}
