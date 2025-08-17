class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                for (int i = 0; i < count; i++)
                    sb.append(ch);
            }
            map.remove(ch);
        }

        for (char ch : map.keySet()) {
            int count = map.get(ch);
            for (int i = 0; i < count; i++)
                sb.append(ch);
        }

        return sb.toString();
    }
}