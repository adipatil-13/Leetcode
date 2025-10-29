class Solution {
    public int smallestNumber(int n) {
        // int x = 1;
        // while (x < n) {
        //     x = x * 2 + 1;
        // }
        // return x;
        while ((n & (n + 1)) != 0) {
		    n |= n + 1;
	    }
	    return n;
    }
}