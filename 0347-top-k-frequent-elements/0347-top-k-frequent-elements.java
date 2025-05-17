class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //O(n), O(n)
        if (k == nums.length) return nums;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            for (int num : freq[i]) {
                res[idx++] = num;
                if (idx == k) {
                    return res;
                }
            }
        }
        return new int[0];
    }
}
/*
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // O(n log k), O(n)
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );
        
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            heap.offer(entry);
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(heap.poll()).getKey();
        }
        
        return res;        
    }
}
*/