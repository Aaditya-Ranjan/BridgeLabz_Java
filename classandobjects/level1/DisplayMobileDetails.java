package level1;

/*
 * This class stores mobile phone information such as
 * brand, model, and price, and displays it using a method.
 */

class DisplayMobileDetails {

    String brand;
    String model;
    double price;

    /*
     * This method prints complete mobile details
     * in a clear and readable format.
     */
    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    /*
     * Main method creates a mobile object,
     * assigns values, and displays the details.
     */
    public static void main(String[] args) {
        DisplayMobileDetails m = new DisplayMobileDetails();

        m.brand = "Samsung";
        m.model = "S21";
        m.price = 55000;

        m.display();
    }
}
