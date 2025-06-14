class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        return max(s) - min(s);
    }
    private int max(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '9') {
                return Integer.parseInt(s.replace(c + "", "9"));
            }
        }
        return Integer.parseInt(s);
    }
    private int min (String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > '0') {
                return Integer.parseInt(s.replace(c + "", "0"));
            }
        }
        return Integer.parseInt(s);
    }
}