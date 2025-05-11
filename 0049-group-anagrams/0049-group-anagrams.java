class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            
            Arrays.sort(chars);

            String sorted = new String(chars);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
// Map<String, List<String>> res = new HashMap<>();
// for (String s : strs) {
//     int[] count = new int[26];
//     for (char c : s.toCharArray()) {
//         count[c - 'a']++;
//     }
//     String key = Arrays.toString(count);
//     res.putIfAbsent(key, new ArrayList<>());
//     res.get(key).add(s);
// }
// return new ArrayList<>(res.values());