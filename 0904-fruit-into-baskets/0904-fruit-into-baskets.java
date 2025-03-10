class Solution {
    public int totalFruit(int[] fruits) {
        //Find the longest continuous sub array that has exactly 2 distinct elements
        Map<Integer, Integer> map = new HashMap<>();

        int begin = 0, end = 0, type = 0, maxLen = 0;
        while (end < fruits.length) {
            int in = fruits[end++];
            
            if (map.getOrDefault(in, 0) == 0) type++;
            map.put(in, map.getOrDefault(in, 0) + 1);

            while (type > 2) {
                int out = fruits[begin++];
                if (map.put(out, map.get(out) - 1) == 1) type--; 
            }
            maxLen = Math.max(maxLen, end - begin); 
        }
        return maxLen; 
    }
}