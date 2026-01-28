package level1;

/*
 * This class stores basic book information such as
 * title, author, and price, and displays it using a method.
 */

class DisplayBookDetails {

    String title;
    String author;
    double price;

    /*
     * This method prints all book details
     * in a readable format.
     */
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    /*
     * Main method creates an object,
     * assigns values, and calls display().
     */
    public static void main(String[] args) {
        DisplayBookDetails b = new DisplayBookDetails();

        b.title = "Java Basics";
        b.author = "James";
        b.price = 299;

        b.display();
    }
}
