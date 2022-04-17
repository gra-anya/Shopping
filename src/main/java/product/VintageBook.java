package product;


public class VintageBook extends Book {
    private String name;
    private String title;
    private String author;
    private int price;
    private int pages;
    private Condition condition;

    public VintageBook(String title, String author, int price) {
        super(title, author, price);
        this.name = title + ". " + author;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
