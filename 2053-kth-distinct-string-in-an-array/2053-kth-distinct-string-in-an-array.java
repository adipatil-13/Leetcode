class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Boolean> map = new HashMap<>();

        for (String s : arr) {
            if (map.containsKey(s)) {
                map.put(s, false);
            } else {
                map.put(s, true);
            }
        }

        for (String s : arr) {
            if (map.get(s) == true) {
                k--;
                if (k <= 0) return s;
            }
        }
        return "";
    }
}