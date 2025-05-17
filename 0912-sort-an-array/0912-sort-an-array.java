class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void merge(int[] nums, int left, int mid, int right){
        int leftLen = mid - left + 1;
        int rightLen = right - mid;

        int[] leftPart = new int[leftLen];
        int[] rightPart = new int[rightLen];

        // for (int i = 0; i < leftLen; i++) {
        //     leftPart[i] = nums[i + left];
        // }

        // for (int i = 0; i < rightLen; i++) {
        //     rightPart[i] = nums[mid + 1 + i];
        // }
        System.arraycopy(nums, left, leftPart, 0, leftLen);
        System.arraycopy(nums, mid + 1, rightPart, 0, rightLen);

        int leftPtr = 0, rightPtr = 0, numsIdx = left;

        while (leftPtr < leftLen && rightPtr < rightLen) {
            if (leftPart[leftPtr] < rightPart[rightPtr]) {
                nums[numsIdx] = leftPart[leftPtr];
                leftPtr++;
            } else {
                nums[numsIdx] = rightPart[rightPtr];
                rightPtr++;
            }
            numsIdx++;
        }

        while (leftPtr < leftLen) {
            nums[numsIdx++] = leftPart[leftPtr++];
        }

        while (rightPtr < rightLen) {
            nums[numsIdx++] = rightPart[rightPtr++];
        }
    }
    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }
}
// class Solution {
//     public int[] sortArray(int[] nums) {
//         // SC : O(n)
//         PriorityQueue<Integer> pQ = new PriorityQueue<>();
//         for(int num : nums) pQ.add(num); //O(n logn)
//         for (int i = 0; i < nums.length; i++) nums[i] = pQ.poll(); //O(n logn)
//         return nums;
//     }
// }