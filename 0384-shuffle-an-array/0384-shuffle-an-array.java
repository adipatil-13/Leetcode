class Solution {
    private final Integer[] nums;
    private final Integer[] res;
    private final Random rand = new Random();

    public Solution(int[] nums) {
        this.nums = new Integer[nums.length];
        res = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            this.nums[i] = nums[i];
            res[i] = nums[i];
        }
    }
    
    public Integer[] reset() {
        return nums;
    }
    
    public Integer[] shuffle() {
        for (int i = nums.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1); 

            Integer temp = res[i];
            res[i] = res[j];
            res[j] = temp;
        }
        return res;
    }
}
