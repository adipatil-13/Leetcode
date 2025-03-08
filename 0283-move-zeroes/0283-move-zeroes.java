class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
            }
        }
    }
}

#Sol2

public void moveZeroes(int[] nums) {
    int snowBallSize = 0; 
    for (int i=0;i<nums.length;i++){
	     if (nums[i]==0){
             snowBallSize++; 
          }
          else if (snowBallSize > 0) {
	        int t = nums[i];
	        nums[i]=0;
	         nums[i-snowBallSize]=t;
          }
     }
}
