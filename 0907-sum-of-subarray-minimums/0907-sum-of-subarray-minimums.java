class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int MOD = 1000000007; 


        long sumMins = 0; 

        for (int i = 0; i <= arr.length; i++) {
            
            while (!st.empty() && (i == arr.length || arr[st.peek()] >= arr[i])) {
                int mid = st.pop(); 

                int leftBoundary = st.empty() ? -1 : st.peek();
                int rightBoundary = i;

                long count = (mid - leftBoundary) * (rightBoundary - mid) % MOD;

                sumMins += (count * arr[mid]) % MOD;
                sumMins %= MOD; 
            }
            st.push(i);
        }
        return (int)sumMins; 
    }
}