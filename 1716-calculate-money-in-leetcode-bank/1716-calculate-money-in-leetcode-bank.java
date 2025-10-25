class Solution {
    public int totalMoney(int n) {
        int res = 0;

        int monday = 1;

        while (n > 0) {
            int money = monday;
            for (int i = 1; i <= Math.min(n, 7); i++) {
                res += money;
                money++;
            }
            n -= 7;
            monday++;
        }
        return res;
    }
}