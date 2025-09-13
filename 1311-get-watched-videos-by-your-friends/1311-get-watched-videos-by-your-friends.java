class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        vis.add(id);
        int currLevel = 0;

        while (!queue.isEmpty() && currLevel < level) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currId = queue.poll();
                for (int friend : friends[currId]) {
                    if (!vis.contains(friend)) {
                        vis.add(friend);
                        queue.offer(friend);
                    }
                }
            }
            currLevel++;
        }
        HashMap<String, Integer> freqMap = new HashMap<>();
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            for (String video : watchedVideos.get(curId)) {
                freqMap.put(video, freqMap.getOrDefault(video, 0) + 1);
            }
        }
         List<Pair> videoList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            videoList.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(videoList);
        List<String> res = new ArrayList<>();
        for (Pair pair : videoList) {
            res.add(pair.video);
        }
        return res;
    }
    class Pair implements Comparable<Pair> {
        String video;
        int freq;

        Pair(String video, int freq) {
            this.video = video;
            this.freq = freq;
        }

        public int compareTo(Pair that) {
            if (this.freq == that.freq) {
                return this.video.compareTo(that.video); 
            }
            return this.freq - that.freq;
        }
    }
}