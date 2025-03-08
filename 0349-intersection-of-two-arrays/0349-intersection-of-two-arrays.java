class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        List<Integer> list = new ArrayList<>();
        for(int num : nums1){
            freq[num]++;
        }
        for(int num : nums2){
            if(freq[num] > 0){
                list.add(num);
                freq[num] = 0;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}

/*public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        for(int num : nums1){
            set.add(num);
        }
        for(int n : nums2){
            if(set.contains(n)){
                intersection.add(n);
            }
        }
        int[] sol = new int[intersection.size()];
        int i = 0;
        for(int num : intersection){
            sol[i++] = num;
        }
        return sol;
    }
*/
