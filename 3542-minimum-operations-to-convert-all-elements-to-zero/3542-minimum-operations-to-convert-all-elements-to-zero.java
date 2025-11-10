class Solution {
    public int minOperations(int[] nums) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(0);
        int res = 0;

        for (int num : nums) {
            while (!dq.isEmpty() && dq.peek() > num) {
                dq.pop();
            }
            if (dq.isEmpty() || num > dq.peek()) {
                res++;
                dq.push(num);
            }
        }
        return res;
    }
}