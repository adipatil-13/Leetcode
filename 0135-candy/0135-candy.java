class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] l2r = new int[n];
        int[] r2l = new int[n];

        for (int i = 0; i < n; i++) {
            l2r[i] = 1;
            r2l[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                l2r[i] = Math.max(l2r[i], l2r[i - 1] + 1);
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                r2l[i] = Math.max(r2l[i], r2l[i + 1] + 1);
            }
        }

        int resCount = 0;
        for (int i = 0; i < n; i++) {
            resCount += Math.max(l2r[i], r2l[i]);
        }

        return resCount;
    }
}
// class Solution {
//     public int candy(int[] ratings) {
//         int n = ratings.length;
//         int candy = n; // Each person is given one candy initially
        
//         int i = 1;
//         while (i < n) {
//             // If current rating is equal to the previous one, just continue
//             if (ratings[i] == ratings[i - 1]) {
//                 i++;
//                 continue;
//             }
            
//             // For increasing slope
//             int peak = 0;
//             while (i < n && ratings[i] > ratings[i - 1]) {
//                 peak++;
//                 candy += peak;
//                 i++;
//                 if (i == n) return candy;
//             }
            
//             // For decreasing slope (ratings[i] < ratings[i-1])
//             int valley = 0;
//             while (i < n && ratings[i] < ratings[i - 1]) {
//                 valley++;
//                 candy += valley;
//                 i++;
//             }
            
//             // Remove the minimum candies from the peak as it was added twice (once from left, once from right)
//             candy -= Math.min(peak, valley);
//         }
//         return candy;
//     }
// }
