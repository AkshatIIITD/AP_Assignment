import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

final class Book {
    private final String bookName;
    private final int ISBN;
    private final int barCode;
    
    Book(String assignedBookName, int assignedISBN, int assignedBarCode) {
        bookName = assignedBookName;
        ISBN = assignedISBN;
        barCode = assignedBarCode;
    }

    String getBookName() {
        return bookName;
    }

    int getBookISBN() {
        return ISBN;
    }

    int getBookBarCode() {
        return barCode;
    }
}

class Rack {
    final int noOfbooks;
    ArrayList<Book> bookContained;

    Rack(int noOfbooks) {
        this.noOfbooks = noOfbooks;
        bookContained = new ArrayList<>();
    }

    Comparator<Book> compareNames = (Book b1, Book b2) -> b1.getBookName().compareTo(b2.getBookName());
    Comparator<Book> compareISBN = (Book b1, Book b2) -> Integer.toString(b1.getBookISBN()).compareTo(Integer.toString(b2.getBookISBN()));
    Comparator<Book> compareBarCode = (Book b1, Book b2) -> Integer.toString(b1.getBookBarCode()).compareTo(Integer.toString(b2.getBookBarCode()));

    void addBookToRack(Book bookToBeAdded) {
        bookContained.add(bookToBeAdded);
    }

    void sortBooksInThisRack() {
        Collections.sort(bookContained, compareNames);
    }
}


public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Rack> racks = new ArrayList<>();
        System.out.print("Enter the number of books: ");
        int n = Integer.parseInt(in.nextLine());
        System.out.print("Enter the number of racks: ");
        int k = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name of book number "+(i+1)+": ");
            String assignedBookName = in.nextLine();
            System.out.print("Enter the ISBN of book number "+(i+1)+": ");
            int assignedISBN = Integer.parseInt(in.nextLine());
            System.out.print("Enter the name of book number "+(i+1)+": ");
            int assignedBarCode = Integer.parseInt(in.nextLine());
            // racks.set(index, element)
        }

        in.close();
    }
}
