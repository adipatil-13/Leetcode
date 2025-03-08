class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;

        for(int i = 0; i < height.length; i++){
            int area = (right - left) * Math.min(height[right], height[left]);
            res = Math.max(res, area);
            if(height[right] > height[left]){
                left++;
            } else{
                right--;
            }
        }
        return res;
    }
}