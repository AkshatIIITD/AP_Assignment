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

    public String getBookName() {
        return bookName;
    }

    public int getBookISBN() {
        return ISBN;
    }

    public int getBookBarCode() {
        return barCode;
    }
}

final class Rack {
    private final int rackNo;
    private final int noOfbooks;
    private final List<Book> bookContained;

    Rack(int noOfbooks, int rackNo, List<Book> bookContained) {
        this.noOfbooks = noOfbooks;
        this.rackNo = rackNo;
        this.bookContained = bookContained;
    }

    public List<Book> getBookContained() {
        return bookContained;
    }

    public int getNoOfbooks() {
        return noOfbooks;
    }

    public int getRackNo() {
        return rackNo;
    }
}

public class App {
    //comparators used
    public static Comparator<Book> compareNames = (Book b1, Book b2) -> b1.getBookName().compareTo(b2.getBookName());
    public static Comparator<Book> compareISBN = (Book b1, Book b2) -> Integer.toString(b1.getBookISBN()).compareTo(Integer.toString(b2.getBookISBN()));
    public static Comparator<Book> compareBarCode = (Book b1, Book b2) -> Integer.toString(b1.getBookBarCode()).compareTo(Integer.toString(b2.getBookBarCode()));

    public static void addBooksToRacks(int n, int k, ArrayList<Book> bookList, ArrayList<Rack> racks) {
        int i = 0;
        while (i < k) {
            List<Book> booksForRack = bookList.subList((n/k)*i, (n/k)*(i+1));
            Rack temp = new Rack(n/k, i+1, booksForRack);
            racks.add(temp);
            i++;
        }
    }

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
                    if (bookList.get(k2).getBookISBN() == bookList.get(k2+1).getBookISBN()) {
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
        //n and k
        System.out.print("Enter the number of books: ");
        int n = Integer.parseInt(in.nextLine());
        System.out.print("Enter the number of racks: ");
        int k = Integer.parseInt(in.nextLine());
        //lists used
        ArrayList<Rack> racks = new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();
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
        
        sortBooks(bookList); //sorting
        addBooksToRacks(n, k, bookList, racks); //separating booklist
        //printing all books' details
        for (int j = 0; j < racks.size(); j++) {
            for (int j2 = 0; j2 < (n/k); j2++) {
                Book temp = racks.get(j).getBookContained().get(j2);
                System.out.println(
                    "Rack Number: "+racks.get(j).getRackNo()+
                    ", Shelf Number: "+(j2+1)+
                    ", Book name: "+temp.getBookName()+
                    ", Book ISBN: "+temp.getBookISBN()+
                    ", Book BarCode: "+temp.getBookBarCode()
                );
            }
        }
        //finder
        System.out.print("Enter number of books to find: ");
        int noOfBooksToFind = Integer.parseInt(in.nextLine());
        while(noOfBooksToFind > 0) {
            System.out.print("Enter name of the book to find: ");
            String tempName = in.nextLine();
            System.out.print("Enter ISBN of the book to find: ");
            int tempISBN = Integer.parseInt(in.nextLine());
            System.out.print("Enter BarCode of the book to find: ");
            int tempBarCode = Integer.parseInt(in.nextLine());
            int i = 0;
            boolean flag = false;
            while (i < racks.size() && (!flag)) {
                for (int j = 0; j < (n/k); j++) {
                    List<Book> tempBooks = racks.get(i).getBookContained();
                    if (tempBooks.get(j).getBookName().equals(tempName) && 
                        tempBooks.get(j).getBookISBN() == tempISBN &&
                        tempBooks.get(j).getBookBarCode() == tempBarCode) {
                        
                        System.out.println(
                            "Rack Number: "+racks.get(i).getRackNo()+
                            ", Shelf Number: "+(j+1)
                        );
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
                i++;
                if (i == k && (!flag)) {
                    System.out.println("Not found!!");
                }
            }
            noOfBooksToFind--;
        }
        in.close();
    }
}