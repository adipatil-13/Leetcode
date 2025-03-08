class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int start = 0, end = 0;

        for(int i = 0; i < s.length(); i++){
            int len1 = checkPalindrome(s, i, i);
            int len2 = checkPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > (end - start)){
                end = i + len / 2;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private int checkPalindrome(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end - start - 1;
    }
}
/* b a b a b a
Initial values:
left = 3, right = 3 (centered on the middle b).
Expansion:
First check: s[3] == s[3] → 'b' == 'b' → True.
Expand outwards:
left = 2, right = 4.
Second check: s[2] == s[4] → 'a' == 'a' → True.
Expand outwards:
left = 1, right = 5.
Third check: s[1] == s[5] → 'b' == 'b' → True.
Expand outwards:
left = 0, right = 6.
Fourth check: s[0] == s[6] → 'a' == 'a' → True.
Expand outwards:
left = -1, right = 7 → out of bounds.
right - left - 1 = 7 - (-1) - 1 = 7
*/
