class Solution {
    public int majorityElement(int[] nums) {
        //MOORE'S VOTING ALGORITHM O(n), O(1)
        int count = 0, max = 0;

        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                max = nums[i];
            }
            if(max == nums[i]) count++;
            else count--;
        }
        return max;
    }
}