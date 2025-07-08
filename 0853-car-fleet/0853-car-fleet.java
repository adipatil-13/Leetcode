class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] time = new double[target];

        for (int i = 0; i < n; i++) {
            time[position[i]] = (double)(target - position[i]) / speed[i];
        }
        
        int fleet = 0;
        double prevTime = 0;

        for (int i = target - 1; i >= 0; i--) {
            if (time[i] > prevTime) {
                fleet++;
                prevTime = time[i];
            }
        }
        return fleet;
    }
}