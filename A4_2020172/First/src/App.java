import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
    List<Book> bookContained;

    Rack(int noOfbooks) {
        this.noOfbooks = noOfbooks;
    }
}

public class App {

    public static Comparator<Book> compareNames = (Book b1, Book b2) -> b1.getBookName().compareTo(b2.getBookName());
    public static Comparator<Book> compareISBN = (Book b1, Book b2) -> Integer.toString(b1.getBookISBN()).compareTo(Integer.toString(b2.getBookISBN()));
    public static Comparator<Book> compareBarCode = (Book b1, Book b2) -> Integer.toString(b1.getBookBarCode()).compareTo(Integer.toString(b2.getBookBarCode()));
    
    

    public static void sortBooks(ArrayList<Book> bookList) {
        Collections.sort(bookList, compareNames);
        for (int i = 0; i < bookList.size(); i++) {
            int j = i;
            while (j < bookList.size()) {
                if (j != bookList.size() - 1  && (bookList.get(j).getBookName().equals(bookList.get(j+1).getBookName()))) {
                    j++;
                } else {
                    break;
                }
            }
            if (j > i) {
                Collections.sort(bookList.subList(i, j+1), compareISBN);
            }
            int k1 = i;
            int k2 = i;
            while(k1 < bookList.size() && k2 < bookList.size()) {
                if((k1 != (bookList.size() - 1)) && (k2 != (bookList.size() - 1))) {
                    if (Integer.toString(bookList.get(k2).getBookISBN()).equals(Integer.toString(bookList.get(k2+1).getBookISBN()))) {
                        k2++;
                    } else {
                        if (k2 == k1) {
                            k1++;
                            k2++;
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            if (k2 > k1) {
                Collections.sort(bookList.subList(k1, k2+1), compareBarCode);
            }
            i = k2;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n = Integer.parseInt(in.nextLine());
        System.out.print("Enter the number of racks: ");
        int k = Integer.parseInt(in.nextLine());

        ArrayList<Rack> racks = new ArrayList<>(k);
        ArrayList<Book> bookList = new ArrayList<>(n);
        ArrayList<Integer> barCodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name of book number "+(i+1)+": ");
            String assignedBookName = in.nextLine();
            System.out.print("Enter the ISBN of book number "+(i+1)+": ");
            int assignedISBN = Integer.parseInt(in.nextLine());
            System.out.print("Enter the Bar Code of book number "+(i+1)+": ");
            int assignedBarCode = Integer.parseInt(in.nextLine());
            if (barCodeList.contains(assignedBarCode)) {
                System.out.println("Bar Code already exists");
            } else {
                bookList.add(new Book(assignedBookName, assignedISBN, assignedBarCode));
            }
        }
        sortBooks(bookList);
        int i = 0;
        while (i < k) {
            Rack temp = new Rack(n/k);
            temp.bookContained = bookList.subList((n/k)*i, (n/k)*(i+1));
            racks.add(temp);
            i++;
        }
        in.close();
        for (int j = 0; j < racks.size(); j++) {
            for (int j2 = 0; j2 < racks.get(j).bookContained.size(); j2++) {
                Book temp = racks.get(j).bookContained.get(j2);
                System.out.println(
                    "RackNO: "+(j+1)+
                    ", Book name: "+temp.getBookName()+
                    ", Book ISBN: "+temp.getBookISBN()+
                    ", Book BarCode: "+temp.getBookBarCode()
                );
            }
        }
    }
}