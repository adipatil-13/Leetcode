class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 1000000;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int sum = 0;
            for(int n : nums) {
                sum += (n + mid - 1) / mid;
            }
            if(sum <= threshold) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
/*
class Solution {
    public int maxele(int nums[]) {
        int max = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) max = nums[i];
        }
        return max;
    }
    public int function(int nums[], int sample)
    {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += Math.ceil((double)(arr[i]) / (double)(sample));
        }
        return total;
    }
    public int smallestDivisor(int[] arr, int limit) {
        int max = maxele(arr);
        int left = 1;
        int right = max;

        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = function(arr,mid);
            if(sum <= limit) right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}
*/