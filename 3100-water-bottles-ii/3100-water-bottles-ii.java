class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            numBottles -= numExchange - 1;
            numExchange++;
            res++;
        }
        return res;
    }
}