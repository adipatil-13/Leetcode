class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while (left < right && (right - left + 1) > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }
            if ((right - left + 1) == k) {
                list.add(helper(freqMap, x));
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;

        
    }
    private int helper(Map<Integer, Integer> freqMap, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[0] == a[0]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        int sum = 0;

        while (x-- > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            int freq = top[0];
            int num = top[1];
            sum += num * freq;
        }
        return sum;
    }
}