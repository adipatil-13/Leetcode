class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int lenGCD = gcd(str1.length(), str2.length());
        return str1.substring(0, lenGCD);
    }
    private int gcd(int len1, int len2) {
        while (len2 != 0) {
            int temp = len1 % len2;
            len1 = len2;
            len2 = temp;
        }
        return len1;
    }
}
/*
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        } else if (str1.equals(str2)) {
            return str1;
        } else if (str1.startsWith(str2)) {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        } else {
            return "";
        }
    }
}
*/
