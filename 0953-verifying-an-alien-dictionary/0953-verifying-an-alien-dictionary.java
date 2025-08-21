class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        //O(no. of words * avg length of word), O(1)
        int[] orderIdx = new int[26];

        for (int i = 0; i < order.length(); i++) {
            orderIdx[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i], word2 = words[i + 1];
            int j = 0;

            for (; j < word1.length(); j++) {
                if (j == word2.length()) return false;
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (orderIdx[word1.charAt(j) - 'a'] > orderIdx[word2.charAt(j) - 'a']) return false;
                    break;
                }
            }
        } 
        return true;
    }
}