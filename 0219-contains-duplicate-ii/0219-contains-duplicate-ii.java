class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //Distance k between same value elements(nums[i] == nums[j] and abs(i - j) <= k)
        Map<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (seen.containsKey(val) && i - seen.get(val) <= k) {
                return true;
            }
            seen.put(val, i);
        }
        return false; 
    }
}