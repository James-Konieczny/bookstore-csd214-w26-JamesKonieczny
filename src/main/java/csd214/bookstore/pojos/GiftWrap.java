package csd214.bookstore.pojos;

public class GiftWrap implements SaleableItem {
    public void sellItem() {
        System.out.println("Gift Wrapping Service sold!");
    }
    public double getPrice() {
        System.out.println("Gift Wrapping Service sold!");
        return 2.00;
    }
}
