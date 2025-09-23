class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1StrArr = version1.split("\\.");
        String[] v2StrArr = version2.split("\\.");

        int len = Math.max(v1StrArr.length, v2StrArr.length);

        for (int i = 0; i < len; i++) {
            int v1 = i < v1StrArr.length ? Integer.parseInt(v1StrArr[i]) : 0;
            int v2 = i < v2StrArr.length ? Integer.parseInt(v2StrArr[i]) : 0;

            if (v1 < v2) return -1;
            if (v1 > v2) return 1;
        }
        return 0;
    }
}