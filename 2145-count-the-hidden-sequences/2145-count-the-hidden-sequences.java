class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0, max = 0, sum = 0;

        for (int diff : differences) {
            sum += diff;
            min = Math.min(min, sum); 
            max = Math.max(max, sum); 
        }
        long range = (long)upper - (long)lower - (max - min);
        if (range < 0) return 0;

        return (int)(range + 1);
    }
}