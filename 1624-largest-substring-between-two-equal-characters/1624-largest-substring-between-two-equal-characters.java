class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> firstIdx = new HashMap<>();
        int res = -1;

        for (int i = 0; i < s.length(); i++) {
            if (firstIdx.containsKey(s.charAt(i))) {
                res = Math.max(res, i - firstIdx.get(s.charAt(i)) - 1);
            } else {
                firstIdx.put(s.charAt(i), i);
            }
        }
        return res;
    }
}