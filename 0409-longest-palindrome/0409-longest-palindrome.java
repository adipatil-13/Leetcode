class Solution {
    public int longestPalindrome(String s) {
       boolean hasOddFreq = false;
        int count = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int freq : map.values()) {
            if (freq % 2 == 0) {
                count += freq;
            } else {
                count += freq - 1;
                hasOddFreq = true;
            }
        }
        return hasOddFreq ? count + 1 : count;

    }
}