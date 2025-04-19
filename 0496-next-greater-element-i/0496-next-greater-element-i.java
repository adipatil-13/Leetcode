class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int num : nums2) {
            while (!st.isEmpty() && st.peek() < num) {
                map.put(st.pop(), num);  
            }
            st.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}
/*
nums1 = [4, 1, 2], nums2 = [1, 3, 4, 2]

stack = [1]
map.put(1, 3)

stack = [3]
map.put(3, 4)

map.getOrDefault(nums1[i], -1) attempts to retrieve value for nums1[i] in the map. If number isn't found in the map (no next greater element exists for that number), return the default value -1.
*/