class Solution {
    public int[][] divideArray(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }

        List<List<Integer>> list = new ArrayList<>();

        while (pq.size() >= 3) {
            int low = pq.poll();
            int mid = pq.poll();
            int high = pq.poll();

            if (high - low <= k) {
                list.add(Arrays.asList(low, mid, high));
            } else {
                return new int[][]{};
            }
        }

        int[][] res = new int[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> triplet = list.get(i);
            res[i][0] = triplet.get(0);
            res[i][1] = triplet.get(1);
            res[i][2] = triplet.get(2);
        }

        return res;
    }
}