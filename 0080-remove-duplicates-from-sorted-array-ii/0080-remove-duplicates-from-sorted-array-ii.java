class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 2;

        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[k - 2]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;

        /* int cnt = 0, curr = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i -1]){
                cnt = 0;
                cur++;
                nums[curr] = nums[i];
            } else{
                cnt++;
                if(cnt <= 1) nums[curr++] = nums[i];
            }
        }
        return curr;
        */
    }
}