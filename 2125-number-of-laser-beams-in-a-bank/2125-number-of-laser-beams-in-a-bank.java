class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int prev = helper(bank[0]);

        for (int i = 1; i < bank.length; i++) {
            int curr = helper(bank[i]);
            if (curr == 0) continue;
            
            res += (prev * curr);
            prev = curr;
        }
        return res;
    }
    private int helper(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++)
            res += (s.charAt(i) - '0');

        return res;
    }
}