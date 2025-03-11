class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0, left = 0;
        int[] chars = new int[3];

        for(int right = 0; right < s.length(); right++){
            chars[s.charAt(right) - 'a']++;

            while(chars[0] > 0 && chars[1] > 0 && chars[2] > 0){
                count += s.length() - right;
                chars[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return count;
    }
}