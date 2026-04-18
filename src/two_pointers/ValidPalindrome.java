package two_pointers;

/**
 * Problem: Valid Palindrome
 * Concepts: Two Pointers, String Manipulation
 * 
 * Description:
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters 
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 */
public class ValidPalindrome {

    /**
     * Solution 1: String Reversal (Simple)
     * Strategy: Clean the string using regex, reverse it, and compare.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - Stores the cleaned and reversed strings.
     * 
     * Example: "A man, a plan, a canal: Panama" -> cleaned: "amanaplanacanalpanama" -> true
     */
    public boolean isPalindromeSimple(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    /**
     * Solution 2: Two Pointers (Optimal)
     * Strategy: Use two pointers (left and right) and move them inward.
     * Skip non-alphanumeric characters without creating new strings.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) - In-place comparison.
     * 
     * Example: "race a car" -> false
     */
    public boolean isPalindromeOptimal(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            char lChar = s.charAt(left);
            char rChar = s.charAt(right);
            
            if (!Character.isLetterOrDigit(lChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rChar)) {
                right--;
            } else {
                if (Character.toLowerCase(lChar) != Character.toLowerCase(rChar)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solver = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is Palindrome: " + solver.isPalindromeOptimal(s));
    }
}
