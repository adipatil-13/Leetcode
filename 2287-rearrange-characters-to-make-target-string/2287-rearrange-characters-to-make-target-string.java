class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] freqS = new int[26];
        int[] freqT = new int[26];

        int res = Integer.MAX_VALUE;

        for (char ch : s.toCharArray()) freqS[ch - 'a']++;
        for (char ch : target.toCharArray()) freqT[ch - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (freqT[i] != 0) {
                res = Math.min(res, freqS[i] / freqT[i]);
            }
        }
        return res;
    }
}