class Solution {
    public int fib(int n) {
        int n1 = 0, n2 = 1;
        if(n == 0 || n == 1) return n;

        for(int i = 2; i <= n; i++){
            int temp = n2;
            n2 = n1 + n2;
            n1 = temp;
        }
        return n2;
    }
}