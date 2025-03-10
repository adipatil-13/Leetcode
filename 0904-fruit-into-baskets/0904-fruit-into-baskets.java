class Solution {
    public int totalFruit(int[] fruits) {
        //Find the longest continuous sub array that has exactly 2 distinct elements
        // Variable to track the maximum number of fruits collected
        int max = 0;       
        // Variable to track current maximum fruits collected in the window
        int curMax = 0;     
        // Variables to store the last two different fruit types encountered
        int prev = -1, prev2 = -1;      
        // Tracks the count of consecutive occurrences of 'prev'
        int prevCount = 0;
        // Iterate through the given fruits array (fruit types)
        for (int fruit : fruits) {        
            //If the current fruit is the same as one of the two tracked types, increase the window size
            if (fruit == prev || fruit == prev2) {
                curMax++;
            } else {
                // Update the max fruits collected so far
                max = Math.max(max, curMax);   
                // Reset curMax to include only the last sequence of the previous fruit and the new one
                curMax = prevCount + 1;
            }
            //If the current fruit is the same as the last one, increase its consecutive count
            if (fruit == prev) {
                prevCount++;
            } else {
                // Reset prevCount and update fruit tracking variables
                prevCount = 1;
                prev2 = prev;  // Shift previous fruit type
                prev = fruit;  // Store the new fruit type
            }
        }
        // Return the maximum number of fruits that can be collected
        return Math.max(max, curMax);
    }
}
