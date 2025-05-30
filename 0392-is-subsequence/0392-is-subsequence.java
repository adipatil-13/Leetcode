class Solution {
    public boolean isSubsequence(String s, String t) {
        //O(n), O(1)
        int i = 0, j = 0;
        while (j < t.length() && i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}