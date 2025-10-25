class Solution {
    public int totalMoney(int n) {
        int res = 0, weekStart = 0, day = 1;     
        
        while (n != 0) {
            res += weekStart + day;
            
            if (day % 7 == 0) {
                day = 1;
                weekStart++;
            } else {
                day++;
            }
            n--;
        }
        
        return res;
    }
}