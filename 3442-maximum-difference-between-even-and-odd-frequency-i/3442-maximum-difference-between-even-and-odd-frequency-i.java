class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        int evenMin = s.length(), oddMax = 0;

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] % 2 == 0) {
                evenMin = Math.min(evenMin, freq[s.charAt(i) - 'a']); 
            } else {
                oddMax = Math.max(oddMax, freq[s.charAt(i) - 'a']);
            }
        }
        return oddMax - evenMin;
    }
}