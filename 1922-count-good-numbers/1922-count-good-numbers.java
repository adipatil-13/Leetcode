class Solution {
    public int countGoodNumbers(long n) {
        if (n == 1) return 5;
        long even = (n + 1) / 2;
        long odd = n / 2;
        long mod = 1000000007;
        return (int)((helper(5, even, mod) * helper(4, odd, mod)) % mod);
    }
    private long helper(long x, long n, long mod) {
        long res = 1;

        while (n > 0) {
            if (n % 2 == 0) {
                x = (x * x) % mod;
                n = n / 2;
            } else {
                res = (res * x) % mod;
                n -= 1;
            }
        }
        return res;
    }
}