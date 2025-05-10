class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = next(res);
        }
        return res;
    }
    public String next(String s) {
        StringBuilder res = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) count++;
            else {
                res.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        res.append(count).append(s.charAt(s.length() - 1));
        return res.toString();
    }
}
//O(1.3^n) TC & O(1.3^n) SC