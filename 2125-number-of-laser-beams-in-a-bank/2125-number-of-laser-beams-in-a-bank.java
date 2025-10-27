class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0, res = 0;
        for (String str : bank) {
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') cnt++;
            }
            if (cnt > 0) {
                res += prev * cnt;
                prev = cnt;
            }
        }
        return res;
    }
}