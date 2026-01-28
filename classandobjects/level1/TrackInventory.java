package level1;

/*
 * This class manages item details such as code, name, and price,
 * and calculates the total cost based on given quantity.
 */

class TrackInventory {

    int itemCode;
    String itemName;
    double price;

    /*
     * This method displays item details and
     * calculates the total cost using quantity.
     */
    void displayAndTotal(int quantity) {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + (price * quantity));
    }

    /*
     * Main method creates an item object,
     * assigns values, and calls displayAndTotal().
     */
    public static void main(String[] args) {
        TrackInventory item = new TrackInventory();

        item.itemCode = 11;
        item.itemName = "Pen";
        item.price = 10;

        item.displayAndTotal(5);
    }
}
