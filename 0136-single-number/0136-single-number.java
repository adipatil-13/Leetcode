class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
        /* 
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                seen.remove(num);
            } else {
                seen.add(num);
            }
        }
        return seen.iterator().next();
        */
    }
}