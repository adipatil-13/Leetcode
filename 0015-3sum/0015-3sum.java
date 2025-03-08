class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        for(int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;

            while(l < r){
                int sum = nums[l] + nums[r] + nums[i];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                } else if(sum < 0){
                    l++;
                } else{
                    r--;
                }
            }
        }
        return new ArrayList<>(res);
    }
}