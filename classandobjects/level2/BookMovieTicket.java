package level2;

/*
 * This class handles movie ticket booking.
 * It uses a parameterized constructor to store
 * ticket details and display booking information.
 */

class BookMovieTicket {

    String movieName;
    int seatNumber;
    double price;

    // Initializes movie ticket details using constructor
    BookMovieTicket(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    // Displays booked ticket details
    void display() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat No: " + seatNumber);
        System.out.println("Price: " + price);
    }

    // Main method to create ticket object and display details
    public static void main(String[] args) {
        BookMovieTicket t = new BookMovieTicket("Avengers", 15, 250);
        t.display();
    }
}
