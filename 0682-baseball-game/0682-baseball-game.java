class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("C")) stack.pop();
            else if (op.equals("D")) stack.push(stack.peek() * 2);
            else if (op.equals("+")) {
                int prev = stack.pop();
                int secondPrev = stack.peek();
                int sum = prev + secondPrev;
                stack.push(prev);
                stack.push(sum);
            }
            else stack.push(Integer.parseInt(op));
        }
        int res = 0;
        for (int score : stack) {
            res += score;
        }
        return res;
    }
}