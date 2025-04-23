class Solution {
    public long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }
    private long sumMin(int[] nums) {
        long sum = 0;
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

         for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] > (i < n ? nums[i] : Integer.MIN_VALUE))) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                long count = (mid - left) * (long)(right - mid);
                sum += nums[mid] * count;
            }
            st.push(i);
        }
        return sum;
    }
    private long sumMax(int[] nums) {
        long sum = 0;
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] < (i < n ? nums[i] : Integer.MAX_VALUE))) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                long count = (mid - left) * (long)(right - mid);
                sum += nums[mid] * count;
            }
            st.push(i);
        }
        return sum;
    }
}