class Solution {
    public boolean isPalindrome(int x) {
        int sum = 0;
        int num = x;
        if(x < 0){
            return false;
        }

        while(num != 0){
            int d = num % 10;
            sum = sum * 10 + d;
            num = num / 10;
        }
        if(sum == x){
            return true;
        }
        return false;
    }
}