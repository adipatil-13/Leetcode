class Solution {
    public String firstPalindrome(String[] words) {
        for (String str : words) {
            int l = 0, r = str.length() - 1;
            boolean isPalindrome = true;
            while (l < r) {
                if (str.charAt(l) != str.charAt(r)) {
                    isPalindrome = false;
                    break;
                }
                l++;
                r--;
            }
            if (isPalindrome == true) return str;
        }
        return "";
    }
}