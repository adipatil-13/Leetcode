class Solution {
    public int minBitFlips(int start, int goal) {
        // O(max bits), O(1)
        // if (start == 0 && goal == 0) return 0;
        // int cnt = 0;
        // while (start > 0 || goal > 0) {
        //     if ((start & 1) != (goal & 1)) cnt++;
        //     start >>= 1;
        //     goal >>= 1;
        // }
        // return cnt;
        return Integer.bitCount(start ^ goal);
    }
}
/*
// O(max bits), O(max bits)
if (start == 0 && goal == 0) return 0;
// Flip for the current least significant bit
int flip = (start & 1) != (goal & 1) ? 1 : 0;
// Recurse for the next bits by right-shifting both numbers
return flip + minBitFlips(start >> 1, goal >> 1);

int xorResult = start ^ goal;
int cnt = 0;
// Count the number of 1s in xorResult (differing bits)
while (xorResult != 0) {
    cnt += xorResult & 1; // Increment if the last bit is 1
    xorResult >>= 1; // Shift right to process the next bit
}

Brian Kernighan’s Algorithm

class Solution {
    public int minBitFlips(int start, int goal) {
        // XOR to find differing bits
        int xorResult = start ^ goal;
        int count = 0;
        // count 1s
        while (xorResult != 0) {
            xorResult &= (xorResult - 1); // Clear the lowest set bit
            count++;
        }
        return count;
    }
}

*/