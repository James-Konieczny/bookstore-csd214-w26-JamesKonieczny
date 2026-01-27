package csd214.bookstore.pojos;

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
    public void initialize() {
        super.initialize();

        System.out.println("Enter Page Count:");
        this.pageCount = getInput(0);

        super.initPriceCopies();
    }

    @Override
    public void sellItem() {
        System.out.println("Selling " + getBrand() + " Notebook with " + pageCount + " pages..." );
        setCopies(getCopies() - 1);
    }

    @Override
    public void edit() {
        super.edit();
        System.out.println("Edit Page Count [" + this.pageCount + "]:");
        this.pageCount = getInput(this.pageCount);
    }

    @Override
    public String toString() {
        return "Notebook{Page Count='" + pageCount + "', " + super.toString() + "}";
    }
}

