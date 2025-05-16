class Solution {
    public int maxProductDifference(int[] nums) {
        int firstSmall = Integer.MAX_VALUE, secondSmall = Integer.MAX_VALUE;
        int firstBig = Integer.MIN_VALUE, secondBig = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < firstSmall) {
                secondSmall = firstSmall;
                firstSmall = num;
            } else if (num < secondSmall) {
                secondSmall = num;
            }
            if (num > firstBig) {
                secondBig = firstBig;
                firstBig = num;
            } else if (num > secondBig) {
                secondBig = num;
            }
        }
        return (firstBig * secondBig) - (firstSmall * secondSmall);
    }
}