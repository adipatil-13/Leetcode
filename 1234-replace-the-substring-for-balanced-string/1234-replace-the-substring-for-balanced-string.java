class Solution {
    public int balancedString(String s) {
        int[] count = new int[128];

        int res = s.length(), l = 0, k = s.length() / 4; 

        for(char r : s.toCharArray()){
            count[r]++;
        }
        
        for(int r = 0; r < s.length(); r++){
            count[s.charAt(r)]--;

            while(l < s.length() && count['Q'] <= k && count['W'] <= k && count['E'] <= k && count['R'] <= k){
                res = Math.min(res, r - l + 1);
                count[s.charAt(l++)]++;
            }
        }
        return res;
    }
}