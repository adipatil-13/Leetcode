class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0, prev = 0;
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(prev)) {
                if (neededTime[prev] < neededTime[i]) {
                    res += neededTime[prev];
                } else {
                    res += neededTime[i];
                    neededTime[i] = neededTime[prev];
                }
            }
            prev++;
        }
        return res;
    }
}