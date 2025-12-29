import java.util.*;

abstract class LibraryItem {
    protected String itemId;
    protected String title;
    protected boolean isAvailable = true;

    abstract void checkOut();
    abstract void returnItem();
    abstract void displayInfo();
}

// Book class
class Book extends LibraryItem {
    private String author;
    private String genre;

    public Book(String itemId, String title, String author, String genre) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    void checkOut() {
        if (isAvailable) {
            System.out.println(title + " borrowed successfully!");
            isAvailable = false;
        } else {
            System.out.println(title + " is not available.");
        }
    }

    void returnItem() {
        isAvailable = true;
        System.out.println(title + " returned successfully!");
    }

    void displayInfo() {
        System.out.println("Book ID: " + itemId + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Available: " + isAvailable);
    }
}

// Magazine class
class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String itemId, String title, int issueNumber) {
        this.itemId = itemId;
        this.title = title;
        this.issueNumber = issueNumber;
    }

    void checkOut() {
        if (isAvailable) {
            System.out.println(title + " borrowed for 7 days only!");
            isAvailable = false;
        } else {
            System.out.println(title + " is not available.");
        }
    }

    void returnItem() {
        isAvailable = true;
        System.out.println(title + " returned successfully!");
    }

    void displayInfo() {
        System.out.println("Magazine ID: " + itemId + ", Title: " + title + ", Issue: " + issueNumber + ", Available: " + isAvailable);
    }
}

// DVD class
class DVD extends LibraryItem {
    private int duration;

    public DVD(String itemId, String title, int duration) {
        this.itemId = itemId;
        this.title = title;
        this.duration = duration;
    }

    void checkOut() {
        if (isAvailable) {
            System.out.println(title + " borrowed for 3 days maximum!");
            isAvailable = false;
        } else {
            System.out.println(title + " is not available.");
        }
    }

    void returnItem() {
        isAvailable = true;
        System.out.println(title + " returned successfully!");
    }

    void displayInfo() {
        System.out.println("DVD ID: " + itemId + ", Title: " + title + ", Duration: " + duration + " min, Available: " + isAvailable);
    }
}

// Member class
class Member {
    private String memberId;
    private String name;
    private List<LibraryItem> borrowedItems = new ArrayList<>();

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    void borrowItem(LibraryItem item) {
        item.checkOut();
        borrowedItems.add(item);
    }

    void returnItem(LibraryItem item) {
        item.returnItem();
        borrowedItems.remove(item);
    }

    void displayBorrowedItems() {
        System.out.println("Member: " + name + ", ID: " + memberId);
        if (borrowedItems.isEmpty()) {
            System.out.println("No items borrowed.");
        } else {
            for (LibraryItem item : borrowedItems) {
                item.displayInfo();
            }
        }
        System.out.println("---------------------------");
    }
}

// Polymorphism handler
class AchievePoly {
    static void permit(LibraryItem ref) {
        ref.checkOut();
        ref.displayInfo();
        ref.returnItem();
        ref.displayInfo();
        System.out.println("---------------------------");
    }
}

// Main class
public class OopProgram3 {
    public static void main(String[] args) {
        Book bk = new Book("B101", "Java Programming", "John Doe", "Programming");
        Magazine mg = new Magazine("M201", "Tech Monthly", 45);
        DVD dv = new DVD("D301", "Inception", 148);

        AchievePoly.permit(bk);
        AchievePoly.permit(mg);
        AchievePoly.permit(dv);

        Member mm = new Member("MEM01", "Alice");
        mm.borrowItem(bk);
        mm.borrowItem(mg);
        mm.displayBorrowedItems();
        mm.returnItem(bk);
        mm.displayBorrowedItems();
    }
}
