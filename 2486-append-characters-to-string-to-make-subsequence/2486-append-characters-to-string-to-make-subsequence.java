class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;
        char curr = t.charAt(0);
        for (char ch : s.toCharArray()) {
            if (ch == curr) {
                i++;
                if (i == t.length()) return 0;
                curr = t.charAt(i);
            }
            
        }
        return t.length() - i;
    }
}