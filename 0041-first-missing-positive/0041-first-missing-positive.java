class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= n) {
                if (nums[val - 1] > 0) {
                    nums[val - 1] *= -1;
                } else if (nums[val - 1] == 0) {
                    nums[val - 1] = -1 * (n + 1);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= 0) {
                return i;
            }
        }

        return n + 1;
    }
}
/*
class Solution {
    public int firstMissingPositive(int[] nums) {
        PriorityQueue <Integer> minHeap = new PriorityQueue<>();
        // Add all the positive numbers in the PriorityQueue
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) minHeap.add(nums[i]);
        }
        int minMissing = 1;
        // Check for all minimum missing positive number
        while (!minHeap.isEmpty()) {
            int element = minHeap.poll();
            if(element == minMissing) minMissing ++;
            else if(element > minMissing) break;
        }
        return minMissing;
    }
}
*/