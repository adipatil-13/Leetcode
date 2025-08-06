class Solution {
    public int findLucky(int[] arr) {
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == key) {
                res = Math.max(res, key); 
            }
        }
        return res;
    }
}