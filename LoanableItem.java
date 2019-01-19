public abstract class LoanableItem{
    private int maxLoanPeriod;
    private boolean available;
    private String title;
    

    LoanableItem(String title, int maxLoanPeriod) {
        this.title = title;
        this.maxLoanPeriod = maxLoanPeriod;
        this.available = true;

    }

    void setMaxLoanPeriod(int maxLoanPeriod) {
        this.maxLoanPeriod = maxLoanPeriod;
    }

    void setAvailable(boolean available) {
        this.available = available;
    }

    boolean isAvailable() {
        return this.available;
    }

    int getMaxLoanPeriod() {
        return this.maxLoanPeriod;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





}


    
