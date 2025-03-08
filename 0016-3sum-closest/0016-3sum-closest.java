class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length - 2; i++){
            int l = i + 1, r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(target - sum) < Math.abs(diff)){
                    diff = target - sum;
                } 
                if(target > sum){
                    l++;
                } else{
                    r--;
                }
            }
        }
        return target - diff;
    }
} 