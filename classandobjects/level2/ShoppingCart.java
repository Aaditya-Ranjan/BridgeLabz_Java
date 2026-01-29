package level2;

/*
 * This class simulates a simple shopping cart system.
 * It uses a parameterized constructor to store item details
 * and supports add, remove, and total cost operations.
 */

class ShoppingCart {

    String itemName;
    double price;
    int quantity;

    // Initializes cart details using constructor
    ShoppingCart(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Adds or updates item details in the cart
    void addItem(String name, double p, int q) {
        itemName = name;
        price = p;
        quantity = q;
    }

    // Removes item from the cart
    void removeItem() {
        itemName = null;
        price = 0;
        quantity = 0;
    }

    // Displays item name and total cost
    void displayTotal() {
        System.out.println("Item: " + itemName);
        System.out.println("Total Cost: " + (price * quantity));
    }

    // Main method to test shopping cart operations
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart("Shoes", 2000, 2);
        cart.displayTotal();

        cart.removeItem();
    }
}
