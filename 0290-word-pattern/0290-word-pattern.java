class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char currChar = pattern.charAt(i);

            if (map.containsKey(currChar)) {
                if (!map.get(currChar).equals(words[i])) return false;
            } else {
                map.put(currChar, words[i]);
            }
            if (reverseMap.containsKey(words[i])) {
                if (reverseMap.get(words[i]) != currChar) return false;
            } else {
                reverseMap.put(words[i], currChar);
            }
        }

        return true;
    }
}