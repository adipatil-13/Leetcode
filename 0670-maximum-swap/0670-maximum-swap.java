class Solution {
    public int maximumSwap(int num) {
        int maxIdx = -1, swap1 = -1, swap2= -1;
        char nums[] = Integer.toString(num).toCharArray();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (maxIdx == -1 || nums[i] > nums[maxIdx]) {
                maxIdx = i; 
            } 
            else if (nums[i] < nums[maxIdx]) {
                swap1 = i;
                swap2 = maxIdx;
            }  
        }

        if (swap1 != -1 && swap2 != -1) {
            char temp = nums[swap1];
            nums[swap1] = nums[swap2];
            nums[swap2] = temp;
        }

        return Integer.parseInt(new String(nums)) ;
    }
}