class Solution {
    public List<String> stringMatching(String[] words) {
        //O(n^2 * k), O(n)
        List<String> res = new ArrayList<>();
        Set<String> added = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    if (!added.contains(words[i])) {
                        res.add(words[i]);
                        added.add(words[i]);
                    }
                    break;
                }
            }
        }
        return res;
    }
}