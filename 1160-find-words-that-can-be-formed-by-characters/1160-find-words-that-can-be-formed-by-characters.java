class Solution {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] freq = new int[26];

        for (int i = 0; i < chars.length(); i++) {
            freq[chars.charAt(i) - 'a']++;
        }

        for (String word : words) {
            if (canFormWord(word, freq)) {
                res += word.length();
            }
        }
        return res;
    }
    private boolean canFormWord(String word, int[] freq) {
        int[] wordFreq = new int[26];

        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            wordFreq[ch]++;
            if (wordFreq[ch] > freq[ch]) return false;
        }
        return true;
    }
}