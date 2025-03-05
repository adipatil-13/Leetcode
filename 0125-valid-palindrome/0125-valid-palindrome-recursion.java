class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindromeRecursive(s, 0);
    }
    private boolean isPalindromeRecursive(String s, int i) {
        // Base case: if i is greater than or equal to the halfway point, it's a palindrome
        if (i >= s.length() / 2) return true;
        
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        
        return isPalindromeRecursive(s, i + 1);
    }
}
