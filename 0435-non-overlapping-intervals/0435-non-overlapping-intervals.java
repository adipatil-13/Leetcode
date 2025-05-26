class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int cnt = 1;

        int lastEndTime = intervals[0][1];

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEndTime) {
                cnt += 1;
                lastEndTime = intervals[i][1];
            } 
        }
        return intervals.length - cnt;
    }
}
/*
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int prev_end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (prev_end > intervals[i][0]) {
                res++;
            } else {
                prev_end = intervals[i][1];
            }
        }

        return res;        
    }
}
*/