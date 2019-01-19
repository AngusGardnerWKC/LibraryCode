public class Book extends LoanableItem{
    private String author;

    public Book(String title, String author, int maxLoanPeriod) {
        super(title, maxLoanPeriod);
        this.author = author;
    }

    public void setAuthor() {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
    

}