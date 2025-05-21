class Solution {
    private boolean areVectorsEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] freqS1 = new int[26];
        for (char c : s1.toCharArray()) {
            freqS1[c - 'a']++;
        }

        int[] freqS2 = new int[26];
        int i = 0, j = 0;

        while (j < s2.length()) {
            freqS2[s2.charAt(j) - 'a']++;

            if (j - i + 1 == s1.length()) {
                if (areVectorsEqual(freqS1, freqS2)) {
                    return true;
                }
            }

            if (j - i + 1 < s1.length()) {
                j++;
            } else {
                freqS2[s2.charAt(i) - 'a']--;
                i++;
                j++;
            }
        }
        return false;
    }
}