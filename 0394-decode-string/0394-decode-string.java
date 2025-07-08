class Solution {
    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<StringBuilder> sbtack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                n = n * 10 + (ch - '0');
            } else if (ch == '[') {
                stack.push(n);
                n = 0;
                sbtack.push(sb);
                sb = new StringBuilder();
            } else if (ch == ']') {
                int k = stack.pop();
                StringBuilder temp = sb;
                sb = sbtack.pop();
                while (k-- > 0) {
                    sb.append(temp);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}