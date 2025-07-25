class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1, kIdx;

        while (true) {
            int idx = partition(nums, left, right);
            if (idx == k - 1) {
                kIdx = nums[idx];
                break;
            } 
            if (idx < k - 1) {
                left = idx + 1;
            } else {
                right = idx - 1;
            }
        }
        return kIdx;
    }
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
            if (nums[l] >= pivot) {
                l++;
            }
            if (nums[r] <= pivot) {
                r--;
            }
        }
        int temp = nums[left];
        nums[left] = nums[r];
        nums[r] = temp;
        
        return r;
    }
}
/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) pq.remove();
        }
        return pq.peek();
    }
}
*/