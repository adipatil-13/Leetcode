class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set = new HashSet<>();
        for (int num : arr1) {
            String str = Integer.toString(num);
            String prefix = "";
            for (char ch : str.toCharArray()) {
                prefix += ch;
                set.add(prefix);
            }
        }

        int maxLen = 0;

        for (int num : arr2) {
            String str = Integer.toString(num);
            String prefix = "";
            for (char ch : str.toCharArray()) {
                prefix += ch;
                if (set.contains(prefix)) {
                    maxLen = Math.max(maxLen, prefix.length());
                }
            }
        }
        return maxLen;
    }
}