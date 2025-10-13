class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            if (!isAnagramFreq(res.get(res.size() - 1), words[i])) {
                res.add(words[i]);
            }
        }
        return res;
    }
    
    private boolean isAnagramFreq(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        
        int[] freq = new int[26];
        
        for (char c : word1.toCharArray()) freq[c - 'a']++;
        for (char c : word2.toCharArray()) freq[c - 'a']--;
     
        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }
}