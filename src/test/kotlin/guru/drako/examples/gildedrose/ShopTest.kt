package guru.drako.examples.gildedrose

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import io.kotest.matchers.shouldBe

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ShopTest{


  @Test
  fun `quality degradation of Conjured Items`(){
    val actualItem =  Item(name = "Conjured Mana Cake", sellIn = 0, quality = 6)

    val shop = Shop(items = listOf(
      actualItem
    ))

    for (i in 1..2)
      shop.updateQuality()

    val expectedDesign = Item(name = "Conjured Mana Cake", sellIn = -2, quality = 0)

    actualItem shouldBe expectedDesign
  }

  @Test
  fun `backstage passes quality when date is below 6`(){
    val actualItem =  Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 5, quality = 6)

    val shop = Shop(items = listOf(
      actualItem
    ))

    for (i in 1..3)
      shop.updateQuality()

    val expectedDesign = Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 2, quality = 15)

    actualItem shouldBe expectedDesign
  }

  @Test
  fun `backstage passes quality when date is below 12`(){
    val actualItem =  Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 10, quality = 6)

    val shop = Shop(items = listOf(
      actualItem
    ))

    for (i in 1..3)
      shop.updateQuality()

    val expectedDesign = Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 7, quality = 12)

    actualItem shouldBe expectedDesign
  }


  @Test
  fun `normal items`(){
    val vest =  Item(name = "+5 Dexterity Vest", sellIn = 0, quality = 10)
    val mongoose =  Item(name = "Elixir of the Mongoose", sellIn = 0, quality = 10)


    val shop = Shop(items = listOf(
      vest,
      mongoose
    ))

    for (i in 1..5)
      shop.updateQuality()

    val expectedVest = Item(name = "+5 Dexterity Vest", sellIn = -5, quality = 0)
    val expectedMongoose = Item(name = "Elixir of the Mongoose", sellIn = -5, quality = 0)


    vest shouldBe expectedVest
    mongoose shouldBe expectedMongoose
  }

  @Test
  fun `Brie quality`(){
    val brie =  Item(name = "Aged Brie", sellIn = 0, quality = 0)
    val shop = Shop(items = listOf(
      brie
    ))

    for (i in 1..55)
      shop.updateQuality()

    val expectedBrie = Item(name = "Aged Brie", sellIn = -55, quality = 50)
    brie shouldBe expectedBrie
  }


  @Test
  fun `legendary item`(){
    val brie =  Item(name = "Sulfuras, Hand of Ragnaros", sellIn = 0, quality = 80)
    val shop = Shop(items = listOf(
      brie
    ))

    for (i in 1..55)
      shop.updateQuality()

    val expectedBrie = Item(name = "Sulfuras, Hand of Ragnaros", sellIn = 0, quality = 80)
    brie shouldBe expectedBrie
  }
}