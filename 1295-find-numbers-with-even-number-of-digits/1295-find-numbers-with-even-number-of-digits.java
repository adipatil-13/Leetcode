class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int ele : nums) {
            if (String.valueOf(ele).length() % 2 == 0) count++;
        }
        return count;
    }
}

// int num = 0;
// for(int ele : nums){
//     if (((int)Math.log10(ele) + 1) % 2 == 0) num++;
// }
// return num;
