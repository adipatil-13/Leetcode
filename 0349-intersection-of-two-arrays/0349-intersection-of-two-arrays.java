class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int num : nums2){
            if(set.contains(num)){
                intersection.add(num);
            }
        }
        int[] res = new int[intersection.size()];
        int i = 0;
        for(int num : intersection){
            res[i++] = num;
        }
        return res;
    }
}