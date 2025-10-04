class Solution {
    public int maxArea(int[] height) {
        int resArea = 0;
        int left = 0, right = height.length - 1;

        for (int i = 0; i < height.length; i++) {
            int area = (right - left) * Math.min(height[left], height[right]);
            resArea  = Math.max(resArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return resArea;
    }
}