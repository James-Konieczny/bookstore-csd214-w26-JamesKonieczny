package csd214.bookstore.pojos;

import java.util.Scanner;

public class Notebook extends Stationary {
    private int pageCount;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Notebook(){}

    public Notebook(int pageCount, String brand, double price, int copies){
        super(brand, price, copies);
        this.pageCount = pageCount;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);

        System.out.println("Enter Page Count:");
        this.pageCount = getInput(input, 0);

        super.initPriceCopies(input);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling " + getBrand() + " Notebook with " + pageCount + " pages..." );
        setCopies(getCopies() - 1);
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);
        System.out.println("Edit Page Count [" + this.pageCount + "]:");
        this.pageCount = getInput(input, this.pageCount);
    }

    @Override
    public String toString() {
        return "Notebook{Page Count='" + pageCount + "', " + super.toString() + "}";
    }
}

