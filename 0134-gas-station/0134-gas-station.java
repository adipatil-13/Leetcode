class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }

        if (totalGas < totalCost) return -1;

        int startIdx = 0, currGas = 0;

        for (int i = 0; i < gas.length; i++) {
            currGas += gas[i] - cost[i];
            if (currGas < 0) {
                startIdx = i + 1;
                currGas = 0;
            }
        }

        return startIdx;
    }
}