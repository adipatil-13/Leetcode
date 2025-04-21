class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //Monotonic stack
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>(); 

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIdx = stack.pop();
                res[prevIdx] = i - prevIdx;
            }
            stack.push(i);
        }
        return res;
    }
}