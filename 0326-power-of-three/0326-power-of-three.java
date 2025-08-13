class Solution {
    public boolean isPowerOfThree(int n) {
        int max3power = 1162261467;
        return n > 0 && max3power % n == 0; 
    }
}