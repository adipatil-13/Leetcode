class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
 
        for (String token : tokens) {
            if (isNumber(token)) st.push(Integer.parseInt(token));
            else {
                int top2 = st.pop();
                int top1 = st.pop();
                int res = 0;
                switch (token) {
                    case "+":
                        res = top1 + top2;
                        break;
                    case "-":
                        res = top1 - top2;
                        break;
                    case "*":
                        res = top1 * top2;
                        break;
                    case "/":
                        res = top1 / top2;
                        break;
                }
                st.push(res);
            }
        }
        return st.pop();
    }
    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
/*
//Neetcode 150
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
*/
