class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();

        for (char c : num.toCharArray()) {
            int digit = c - '0';
            while (k > 0 && !st.isEmpty() && st.peek() > digit) {
                k--;
                st.pop();
            }
            st.push(digit);
        }
        
        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() > 0 ? sb.toString() : "0";
    }
}