/*
Example : arr = [2, 3, 4, 7, 11], k = 5

mid = (4 + 4) / 2 = 4 (Iteration 3)
Now, we calculate the number of missing integers up to index mid = 4 (i.e., at arr[4] = 11):
The number of integers up to arr[4] is arr[4] = 11.
The number of missing integers up to index 4 is arr[mid] - (mid + 1) = 11 - 5 = 6.
We compare this number (6) with k: 6 is greater than k = 5, so we move the right pointer to mid - 1 = 3.

Exiting the binary search loop
At this point, left = 4 and right = 3, so the loop ends.

Calculating the 5th missing number. Now, we return left + k:

left = 4 is the index after the binary search finishes.

We need to find the 5th missing number, so we add k = 5 to left.
*/
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((arr[mid] - (mid + 1)) >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left + k;
    }
}
