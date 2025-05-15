class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        boolean[] freq = new boolean[26];

        for (char al : allowed.toCharArray()) {
            freq[al - 'a'] = true;
        }

        for (int i = 0; i < words.length; i++) {
            if (isConsistent(words[i], freq)) {
                count++;
            }
        }
        return count;
    }
    private boolean isConsistent(String word, boolean[] freq) {

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!freq[ch - 'a']) {
                return false;
            }
        }
        return true;
    }
}