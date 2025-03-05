class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            while(l < r && !validChar(s.charAt(l))){
                l++;
            }
            while(l < r && !validChar(s.charAt(r))){
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    private boolean validChar(char ch){
        if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
            return true;
        }
        return false;
    }
}