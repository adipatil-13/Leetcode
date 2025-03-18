class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;

        while (m > 0 && n > 0){
            if(nums1[m - 1] > nums2[n - 1]){
                nums1[end] = nums1[m - 1];
                m--;
            } else {
                nums1[end] = nums2[n - 1];
                n--;
            }
            end--;
        }
        while (n > 0){
            nums1[end] = nums2[n - 1];
            n--;
            end--;
        }
    }
}
/*  System.arraycopy(nums2, 0, nums1, m, n);
    Arrays.sort(nums1); 
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIdx = m - 1;
        int nIdx = n - 1;
        int right = m + n - 1;

        while(nIdx >= 0){
            if(mIdx >= 0 && nums1[mIdx] > nums2[nIdx]){
                nums1[right] = nums1[mIdx];
                mIdx--;
            } else {
                nums1[right] = nums2[nIdx];
                nIdx--;
            }
            right--;
        }
    }
*/