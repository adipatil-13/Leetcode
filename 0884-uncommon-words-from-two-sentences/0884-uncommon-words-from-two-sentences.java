class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String finalString = s1 + " " + s2;
        Map<String, Integer> map = new HashMap<>();

        String[] words = finalString.split(" ");

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> res = new ArrayList<>();

        for (String word : map.keySet()) {
            if (map.get(word) == 1) res.add(word);
        }
        
        return res.toArray(new String[0]);
    }
}