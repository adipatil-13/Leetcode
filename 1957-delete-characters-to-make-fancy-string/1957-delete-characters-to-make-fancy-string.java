class Solution {
    public String makeFancyString(String s) {
        char[] chars = s.toCharArray();
        int start = chars[0];
        int count = 1, leftPos = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != start) {
                count = 0;
                start = chars[i];
            }
            count++;
            if (count > 2) continue;
            chars[leftPos++] = chars[i];
        }

        return new String(chars, 0, leftPos);
    }
}
/*
class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = res.length();
            if (len >= 2 && res.charAt(len - 1) == c && res.charAt(len - 2) == c) {
                continue;
            }
            res.append(c);
        }
        return res.toString();
    }
}
*/