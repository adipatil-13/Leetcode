class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1, right = x;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if ((mid * mid) <= x) {
                left = (int)mid + 1;
            } else {
                right = (int)mid - 1;
            }
        }
        return right;
    }
}