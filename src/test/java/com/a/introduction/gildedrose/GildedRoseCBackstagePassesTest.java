package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseCBackstagePassesTest {

	private static final int QUALITY_INCREASES = 3;
	private static final int ITEM_QUALITY = 3;
	private static final int EXPIRED_SELLIN = 15;

	@Test
	public void sellinReducesBy1_QualityIncreasesBy1() {

		GildedRose app = getItemAndQuality(EXPIRED_SELLIN, ITEM_QUALITY);
		app.updateQuality();

		Item expected = new Item("Backstage passes to a TAFKAL80ETC concert", EXPIRED_SELLIN - 1, ITEM_QUALITY + 1);

		assertItem(app.items[0], expected);
	}

	@Test
	public void testUpdateQualityBackstagePasses2() {
		GildedRose app = getItemAndQuality(EXPIRED_SELLIN, ITEM_QUALITY);
		app.updateQuality();

		Item expected = new Item("Backstage passes to a TAFKAL80ETC concert", EXPIRED_SELLIN - 1, ITEM_QUALITY + 1);

		assertItem(app.items[0], expected);
	}

	@Test
	public void testUpdateQualityBackstagePasses3() {
		GildedRose app = getItemAndQuality(EXPIRED_SELLIN, ITEM_QUALITY);
		app.updateQuality();

		Item expected = new Item("Backstage passes to a TAFKAL80ETC concert", EXPIRED_SELLIN - 1,
				QUALITY_INCREASES + 1);

		assertItem(app.items[0], expected);
	}

	private void assertItem(Item item, Item expected) {
		assertEquals(expected.name, item.name);
		assertEquals(expected.sellIn, item.sellIn);
		assertEquals(expected.quality, item.quality);
	}

	private GildedRose getItemAndQuality(int unexpiredSellin, int unexpiredQuality) {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", unexpiredSellin, unexpiredQuality);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		return app;
	}

}