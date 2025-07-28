class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        // O(n log n), O(n)
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (b.length() != a.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });

        for (String s : nums) {
            pq.offer(s);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}