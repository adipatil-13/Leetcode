class Solution {
    public boolean isIdealPermutation(int[] nums) {
        for(int i = 0; i  < nums.length; i++){
            // 0 can be place at 0th or 1st position only, others at  i - 1 or i + 1 otherwise more global than local
            if (Math.abs(nums[i] - i) > 1) return false;
        }
        return true;
    }
}

/*
public boolean isIdealPermutation(int[] A) {
    int cmax = 0;
    for (int i = 0; i < A.length - 2; ++i) {
        cmax = Math.max(cmax, A[i]);
        if (cmax > A[i + 2]) return false;
    }
    return true;
}
*/