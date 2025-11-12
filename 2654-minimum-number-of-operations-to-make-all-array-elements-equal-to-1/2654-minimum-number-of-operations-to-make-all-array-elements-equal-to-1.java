class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;
        int oGcd = 0;

        for (int num : nums) {
            if (num == 1) ones++;
            oGcd = gcd(oGcd, num);
        }

        if (ones > 0) return n - ones;

        if (oGcd > 1) return -1;

        int minSubarrayGcd1 = n;

        for (int i = 0; i < n; i++) {
            int currGcd = 0;
            for (int j = i; j < n; j++) {
                currGcd = gcd(currGcd, nums[j]);
                if (currGcd == 1) {
                    minSubarrayGcd1 = Math.min(minSubarrayGcd1, j - i + 1);
                    break;
                }
            }
        } 
        return minSubarrayGcd1 + n - 2;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}