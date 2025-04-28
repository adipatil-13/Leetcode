class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left = 0, right = 0;
        long sum = 0, count = 0;

        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left++];
            }
            count += (right - left  + 1);
        }
        return count;
    }
}
/*
import java.util.*;

class Solution {
    public int countSubarrays(int[] nums, int K) {
        int n = nums.length;
        
        // Initialize prefix sum array
        long[] prefix = new long[n + 1];
        prefix[0] = 0; // handle the case of a subarray starting from index 0
        
        // Calculate prefix sum array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // This list will store all the prefix sums that we have seen so far
        List<Long> sortedPrefixSums = new ArrayList<>();
        sortedPrefixSums.add(0L); // Add the initial prefix sum 0
        
        int res = 0;
        
        // Iterate over all prefix sums
        for (int i = 1; i <= n; i++) {
            long target = prefix[i] - K;
            
            // Use binary search to count how many prefix sums are greater than `target`
            int count = binarySearch(sortedPrefixSums, target);
            
            // Increment result by count found by binary search
            res += count;
            
            // Insert current prefix[i] into the sorted list of previous prefix sums
            insertInSortedOrder(sortedPrefixSums, prefix[i]);
        }
        return res;
    }

    // Binary search to find how many prefix sums are greater than target
    private int binarySearch(List<Long> sortedPrefixSums, long target) {
        int low = 0, high = sortedPrefixSums.size() - 1, count = 0;

        // Find first position where prefix sum is greater than target
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedPrefixSums.get(mid) > target) {
                count = sortedPrefixSums.size() - mid; // All elements from mid to end are valid
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return count;
    }

    // Insert prefix[i] into sorted order
    private void insertInSortedOrder(List<Long> sortedPrefixSums, long prefixSum) {
        int low = 0, high = sortedPrefixSums.size() - 1;
        
        // Binary search to find correct insert position
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedPrefixSums.get(mid) < prefixSum) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // Insert at correct position
        sortedPrefixSums.add(low, prefixSum);
    }
}

*/