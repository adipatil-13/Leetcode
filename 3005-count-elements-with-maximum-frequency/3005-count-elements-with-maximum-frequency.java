class Solution {
    public int maxFrequencyElements(int[] nums) {
        short[] freq = new short[101];
        short max = 0, res = 0;

        for (int num : nums) {
            short f = ++freq[num];
            if (f > max) {
                max = f; 
                res = f;
            } else if (f == max) 
                res += f;
        }
        return res;
    }
}