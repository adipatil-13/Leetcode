class Solution {
    public String reverseWords(String s) {
        int left = 0;
        s = s.trim();
        int right = s.length() - 1;
        String temp = "", res = "";
        
        
        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ') {
                temp += ch;
            } else if (ch == ' ' && !temp.isEmpty()) {
                if (!res.isEmpty()) {
                    res = temp + " " + res;
                } else {
                    res = temp;
                }
                temp = "";
            }
            left++;
        }

        if (!temp.isEmpty()) {
            if (res.isEmpty()) {
                res = temp;
            } else {
                res = temp + " " + res;
            }
        }
        return res;
    }
}