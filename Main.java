import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        
        LinkedList<LoanableItem> items = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("books.csv"));
            String line;
            while ((line = br.readLine()) !=null) {
                String[] split = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (split.length > 1) {
                    String author = split[0].replace("\"", "");
                    String title = split[1].replace("\"", "");
                    items.add(new Book(title, author, 30));
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading the book data!");
        }
        System.out.println(items.size() + " items loaded successfully");

        System.out.println("Search Term: ");
        Scanner kb = new Scanner(System.in);
        String query = kb.nextLine();
        

        int index = 1;
        LinkedList<LoanableItem> results = searchByTitle(query, items);
        for (LoanableItem item : results) {
    
            System.out.println(index + ": " + item.getTitle());
            index++;
        }
        String term = results.size() > 1 ? "results" : "result"; 
        System.out.println(results.size() + " " + term +  " found.");

        System.out.println("Please select your book from the list.");
        int selection = kb.nextInt();
        LoanableItem userItem = (results.get(selection - 1));
        System.out.println(userItem.getTitle());
        System.out.println("Max loan period: " + userItem.getMaxLoanPeriod() + " days.");
        


        
    }

        

        private static LinkedList<LoanableItem> searchByTitle(String query, LinkedList<LoanableItem> items) {
        LinkedList<LoanableItem> results = new LinkedList<>();
        for (LoanableItem item : items) {
            if (item.getTitle().toLowerCase().contains(query.toLowerCase())) {
                results.push(item);
            }
        }
        return results;    

        
    

        

        
    }
}