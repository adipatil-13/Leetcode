class Solution {
    public int scoreOfString(String s) {
        int res = 0;

        for (int i = 1; i < s.length(); i++) {
            res += Math.abs((s.charAt(i) - 'A') - (s.charAt(i - 1) - 'A'));
        }
        return res;
    }
}