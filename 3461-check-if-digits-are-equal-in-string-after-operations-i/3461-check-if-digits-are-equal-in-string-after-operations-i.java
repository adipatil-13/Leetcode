class Solution {
    public boolean hasSameDigits(String s) {
        if (s == null || s.length() < 2) return false;
        if (s.length() == 2) return s.charAt(0) == s.charAt(1);
        
        while (s.length() > 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i + 1 < s.length(); i++) {
                sb.append((s.charAt(i) - '0' + s.charAt(i + 1) - '0') % 10);
            }
            s = sb.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}