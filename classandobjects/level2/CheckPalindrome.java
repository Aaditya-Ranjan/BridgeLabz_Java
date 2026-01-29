package level2;

/*
 * This class checks whether a given string is a palindrome.
 * It uses a parameterized constructor to initialize the string
 * and verifies it using string reversal logic.
 */

class CheckPalindrome {

    String text;

    // Initializes the string using constructor
    CheckPalindrome(String text) {
        this.text = text;
    }

    // Checks and returns whether the string is palindrome
    boolean isPalindrome() {
        String rev = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            rev += text.charAt(i);
        }
        return text.equals(rev);
    }

    // Displays palindrome checking result
    void displayResult() {
        if (isPalindrome())
            System.out.println("Palindrome String");
        else
            System.out.println("Not Palindrome");
    }

    // Main method to test palindrome checking
    public static void main(String[] args) {
        CheckPalindrome p = new CheckPalindrome("madam");
        p.displayResult();
    }
}
