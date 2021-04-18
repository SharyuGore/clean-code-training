package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseBAgedBrieTest {

	private static final String AGED_BRIE = "Aged Brie";
	private static final int EXPIRED_SELLIN = -1;
	private static final int ITEM_QUALITY = 3;
	private static final int ITEM_QUALITY_LIMIT = 50;
	private static final int UNEXPIRED_SELLIN = 4;

	@Test
	public void unexpiredItem_qualityIncreaseBy1() {
		GildedRose app = getItemAndQuality(UNEXPIRED_SELLIN, ITEM_QUALITY);
		app.updateQuality();

		Item expected = new Item(AGED_BRIE, UNEXPIRED_SELLIN - 1, ITEM_QUALITY + 1);

		assertItem(app.items[0], expected);
	}

	@Test
	public void expiredItem_qualityIncreaseBy2() {

		GildedRose app = getItemAndQuality(EXPIRED_SELLIN, ITEM_QUALITY);
		app.updateQuality();

		Item expected = new Item(AGED_BRIE, EXPIRED_SELLIN - 1, ITEM_QUALITY + 2);

		assertItem(app.items[0], expected);

	}

	@Test
	public void unexpiredItem_qualityDoesNotGoBeyondMaximum() {

		GildedRose app = getItemAndQuality(UNEXPIRED_SELLIN, ITEM_QUALITY_LIMIT);
		app.updateQuality();

		Item expected = new Item(AGED_BRIE, UNEXPIRED_SELLIN - 1, ITEM_QUALITY_LIMIT);

		assertItem(app.items[0], expected);
	}

	private void assertItem(Item item, Item expected) {
		assertEquals(expected.name, item.name);
		assertEquals(expected.sellIn, item.sellIn);
		assertEquals(expected.quality, item.quality);
	}

	private GildedRose getItemAndQuality(int unexpiredSellin, int unexpiredQuality) {
		Item item = new Item(AGED_BRIE, unexpiredSellin, unexpiredQuality);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		return app;
	}
}
