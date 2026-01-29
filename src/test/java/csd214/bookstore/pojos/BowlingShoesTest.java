package csd214.bookstore.pojos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BowlingShoesTest {

    @Test
    void testEquality(){
        BowlingShoes bs1 = new BowlingShoes(9, "red", 68.99, 42);
        BowlingShoes bs2 = new BowlingShoes(9, "red", 68.99, 30);
        BowlingShoes bs3 = new BowlingShoes(8, "red", 68.99, 42);

        assertEquals(bs1, bs2, "Bowling shoes with same state should be equal");
        assertEquals(bs1.hashCode(), bs2.hashCode(), "HashCodes must match");
        assertNotEquals(bs1, bs3, "Different sized shoes should not be equal");
    }

    @Test
    void testConstructor() {
        BowlingShoes bs = new BowlingShoes(9, "red", 68.99, 42);

        assertEquals(9, bs.getShoeSize());
        assertEquals("red", bs.getColor());
        assertEquals(68.99, bs.getPrice());
        assertEquals(42, bs.getCopies());
    }

    @Test
    void testSellItem() {
        BowlingShoes bs = new BowlingShoes(8, "blue", 72.05, 10);

        bs.sellItem();

        assertEquals(9,bs.getCopies());
    }
}
