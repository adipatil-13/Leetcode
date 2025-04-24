class Solution {
    public int myAtoi(String s) {
        s = s.trim();  
        if (s.length() == 0) return 0;
        char[] str = s.toCharArray();

        int sign = 1, i = 0;
        long res = 0;

        if (str[i] == '-') { 
            sign = -1; 
            i++;
        } 
        else if (str[i] == '+') i++; 

        return helper(str, i, sign, 0L);
    }
    private int helper(char[] str, int i, int sign, long res) {
        if (i == str.length || (str[i] < '0' || str[i] > '9')) return (int)(res * sign);

        res = res * 10 + (str[i] - '0');

        if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return helper(str, i + 1, sign, res);
    }  
}
/*
class Solution {
    public int myAtoi(String s) {
        s = s.trim(); //1 
        if (s.length() == 0) return 0;

        int sign = 1, i = 0;
        long res = 0;

        if (s.charAt(0) == '-') { 
            sign = -1; 
            i++;
        } 
        else if (s.charAt(0) == '+') i++; //2
        
        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch < '0' || ch > '9') break;

            res = res * 10 + (ch - '0'); //3

            if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE; //4
            i++;
        }
        return (int)(sign * res);
    }
}
*/