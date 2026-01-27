package csd214.bookstore.pojos;

import java.util.Objects;

public abstract class Stationary extends Product{
    private String brand;
    private double price = 0.0;
    private int copies = 0;


    public Stationary(String brand, double price, int copies) {
        this.brand = brand;
        this.price = price;
        this.copies = copies;
    }

    // shortcut: alt + insert
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Stationary() {

    }

    @Override
    // I resolved the SaleableItem 'contract' here, like how I saw you do with Publication. I figured if Stationary and Publication are on the same 'level', it would be better here rather than Pen/Notebook. Let me know if this is logical / makes sense.
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getCopies() {
        return copies;
    }
    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Stationary{" +
                "brand='" + brand + '\'' +
                ", price=" + price + ", copies=" + copies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Stationary that)) return false;
        return Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(brand);
    }

    @Override
    public void initialize() {
//        super.initialize(); // Critical: let Parent ask for Name/Price
        System.out.println("Enter Brand:");
        this.brand = getInput("Generic");
    }

    protected void initPriceCopies() {
        System.out.println("Enter copies:");
        this.copies = getInput(0);

        System.out.println("Enter price:");
        this.price = getInput(0.0);
    }

    @Override
    public void edit() {
        // 1. Edit Parent fields (Title, Price, Copies)
//        super.edit();

        // 2. Edit Self fields
        System.out.println("Edit Author [" + this.brand + "]:");
        this.brand = getInput(this.brand);

        System.out.println("Edit Price [" + this.price + "]:");
        this.price = getInput(this.price);

        System.out.println("Edit Copies [" + this.copies + "]:");
        this.copies = getInput(this.copies);
    }
}
