class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0, count = 0, res = 0;

        for(right = 0; right < nums.length; right++){

            if(nums[right] % 2 == 1){
                k--;
                count = 0;
            }
            while (k == 0){
                if(nums[left] % 2 == 1){
                    k++;
                }
                count++;
                left++;
            }
            res += count;
        }
        return res;
    }
}

/*
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    private int atMost(int[] nums, int k) {
        int left = 0, count = 0, oddCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) {
                oddCount++;
            }
            while (oddCount > k) {
                if (nums[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
*/