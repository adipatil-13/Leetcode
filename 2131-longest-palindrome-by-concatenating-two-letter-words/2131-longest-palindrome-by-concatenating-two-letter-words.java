class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;

        for (String word : words) {
            String rev = new StringBuilder(word).reverse().toString();

            if (map.getOrDefault(rev, 0) > 0) {
                res += 4;
                map.put(rev, map.get(rev) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (word.charAt(0) == word.charAt(1) && count > 0) {
                res += 2;
                break;
            }
        }

        return res;
    }
}