class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0, maxElement = 0, maxDiff = 0;
        for (int num : nums) {
            res = Math.max(res, maxDiff * num);
            maxDiff = Math.max(maxDiff, maxElement - num);
            maxElement = Math.max(maxElement, num);
        }
        return res;
    }
}