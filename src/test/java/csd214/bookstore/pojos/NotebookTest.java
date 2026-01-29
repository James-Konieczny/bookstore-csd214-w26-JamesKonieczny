package csd214.bookstore.pojos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NotebookTest {

    @Test
    void testEquality(){
        Notebook nb1 = new Notebook(60, "Leuchtturm1917", 7.50, 20);
        Notebook nb2 = new Notebook(60, "Leuchtturm1917", 7.50, 30);
        Notebook nb3 = new Notebook(110, "Moleskine", 7.50, 20);

        assertEquals(nb1, nb2, "Notebooks with same state should be equal");
        assertEquals(nb1.hashCode(), nb2.hashCode(), "HashCodes must match");
        assertNotEquals(nb1, nb3, "Notebooks with different page counts should not be equal");
    }

    @Test
    void testConstructor() {
        Notebook nb = new Notebook(110, "Moleskine", 7.50, 20);

        assertEquals(110, nb.getPageCount());
        assertEquals("Moleskine", nb.getBrand());
        assertEquals(7.50, nb.getPrice());
        assertEquals(20, nb.getCopies());
    }

    @Test
    void testSellItem() {
        Notebook nb = new Notebook(110, "Moleskine", 7.50, 38);

        nb.sellItem();

        assertEquals(37, nb.getCopies());
    }
}
