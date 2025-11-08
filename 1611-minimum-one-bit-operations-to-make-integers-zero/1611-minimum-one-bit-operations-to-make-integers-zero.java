class Solution {
    public int minimumOneBitOperations(int n) {
        // Gray code is a binary sequence where each number differs from the previous one by only one bit.
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) 
            sb.append(sb.charAt(i - 1) == s.charAt(i) ? '0' : '1');
        
        return Integer.parseInt(sb.toString(), 2);
    }
}

/*
The minimum number of flips can be derived by comparing each bit to the previously processed bit:

If they are the same, no new flip is needed
if they differ, a flip is required.
First, let's initialize a string bit with the first character of s.
Then, iterate over the remaining characters of s.
If the previous bit in bit equals the current bit in s, append 0 to bit.
Otherwise, append 1.
Finally, we convert the final bit string back to an integer.
This integer is the minimum number of operations needed.
*/