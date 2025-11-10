class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 1];
        int top = 0, res = 0;

        for (int i = 0; i < n; i++) {
            while (temp[top] > nums[i]) {
                top--;
                res++;
            }
            if (temp[top] != nums[i])
                temp[++top] = nums[i];
        }
        return res + top;


        // Deque<Integer> dq = new ArrayDeque<>();
        // dq.push(0);
        // int res = 0;

        // for (int num : nums) {
        //     while (!dq.isEmpty() && dq.peek() > num) {
        //         dq.pop();
        //     }
        //     if (dq.isEmpty() || num > dq.peek()) {
        //         res++;
        //         dq.push(num);
        //     }
        // }
        // return res;
    }
}