class Solution {
    public int maximumGain(String s, int x, int y) {
        char ch1 = 'a', ch2 = 'b';
        int res = 0;
        char[] chars = s.toCharArray();
        int count1 = 0, count2 = 0;

        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            ch1 = 'b';
            ch2 = 'a';
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch1) count1++;
            else if (chars[i] == ch2) {
                if (count1 > 0) {
                    count1--;
                    res += x;
                } else {
                    count2++;
                }
            } else {
                res += Math.min(count1, count2) * y;
                count1 = 0;
                count2 = 0;
            }
        }
        if (count1 != 0) {
            res += Math.min(count1, count2) * y;
        }
        return res;
    }
}