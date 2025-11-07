class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        MyComparator comp = new MyComparator();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(comp);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else {
                if (comp.compare(entry, pq.peek()) > 0) {
                    pq.poll();
                    pq.offer(entry);
                }
            }
        }
        List<String> res = new LinkedList<>();
        for (int i = 0; i <= k - 1; i++) {
            res.add(0, pq.poll().getKey());
        }
        return res;
    }
}
class MyComparator implements Comparator<Map.Entry<String, Integer>> {
    public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
        String word1 = entry1.getKey();
        int freq1 = entry1.getValue();
        String word2 = entry2.getKey();
        int freq2 = entry2.getValue();
        if (freq1 != freq2) {
            return freq1 - freq2;
        } else {
            return word2.compareTo(word1);
        }
    }
}