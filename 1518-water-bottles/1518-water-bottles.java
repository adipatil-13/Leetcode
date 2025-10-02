class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }
}
// class Solution {
//     public int numWaterBottles(int numBottles, int numExchange) {
//         int drank = 0, empty = 0;

//         while (numBottles > 0) {
//             drank += numBottles;
//             empty += numBottles;

//             numBottles = empty / numExchange;
//             empty = empty % numExchange;
//         }
//         return drank;
//     }
// }