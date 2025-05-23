class Solution {
    public int characterReplacement(String s, int k) {
        if (s.isEmpty() || k > s.length()) return s.length();

        int[] freq = new int[26];
        int r = 0, l = 0, res = 0, maxFreq = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            if ((r - l + 1) - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
/*
class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxFreq = 0, res = 0;

        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));

            while ((right - left + 1) - maxFreq > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
*/