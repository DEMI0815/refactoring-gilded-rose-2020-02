package com.gildedrose;

import static com.google.common.base.Charsets.UTF_8;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateItemsInOneDay();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(4));
        assertThat(app.items[0].sellIn, is(0));
    }

    @Test
    public void should_match_print_result() throws IOException {
        String result = TextTestFixture.getResult();
        String baseResult = Files.toString(new File("src/test/BaseResult.txt"), UTF_8);

        assertEquals(result, baseResult);
    }

}
