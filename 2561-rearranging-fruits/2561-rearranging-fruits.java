class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int fruit : basket1) map.put(fruit, map.getOrDefault(fruit, 0) + 1);
        for (int fruit : basket2) map.put(fruit, map.getOrDefault(fruit, 0) + 1);

        long min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) return -1;
            min = Math.min(min, entry.getKey());
        }

        Map<Integer, Integer> cnt1 = new HashMap<>();
        for (int fruit : basket1) cnt1.put(fruit, cnt1.getOrDefault(fruit, 0) + 1);

        List<Long> fruits_swap = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int fruit = entry.getKey();
            int diff = cnt1.getOrDefault(fruit, 0) - (entry.getValue() / 2);
            for (int i = 0; i < Math.abs(diff); i++) {
                fruits_swap.add((long)fruit);
            }
        }

        Collections.sort(fruits_swap);

        long totalCost = 0;
        int swaps = fruits_swap.size() / 2;
        for (int i = 0; i < swaps; i++) {
            totalCost += Math.min(fruits_swap.get(i), 2 * min);
        }
        
        return totalCost;
    }
}