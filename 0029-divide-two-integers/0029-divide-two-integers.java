class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        if (divisor == dividend) return 1;
         if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0) != (divisor < 0);

        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        long res = 0;

        while (n >= d){
            int cnt = 0;
            while (n >= (d << (cnt + 1))) cnt++;
            res += 1L << cnt;
            n -= (d << cnt);
        }

        if (res == -(1 << 31) && isNegative) return Integer.MIN_VALUE;
        if (res == (1 << 31) && !isNegative) return Integer.MAX_VALUE;

        return isNegative ? (int)-res : (int)res;
    }
}

/*
21 / 3
3*2^2 + 3*2^1 + 3*2^0 (12 + 6 + 3)
res += 2^0 + 2^1 + 2^2 (iteration 1, 2, 3)
n (21) - 12 - 6 - 3
*/