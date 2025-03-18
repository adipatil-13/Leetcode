// Time Complexity: O(n log n), Space Complexity: O(n) beats 24.14%
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(res.isEmpty() || intervals[i][0] > res.get(res.size() - 1)[1]){
                res.add(new int[] { intervals[i][0], intervals[i][1] });
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

// Time Complexity: O(n log n), Space Complexity: O(n) beats 60%
class Solution {
    public int[][] merge(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[count][1] >= intervals[i][0]) {
                intervals[count][1] = Math.max(intervals[count][1], intervals[i][1]);
            } else {
                count++;
                intervals[count] = intervals[i];
            }
        }
        return Arrays.copyOfRange(intervals, 0, count + 1);
    }
}
