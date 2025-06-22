class Solution {
    public String[] divideString(String s, int k, char fill) {

        int groupK = (s.length() - 1 + k) / k;
        String[] res = new String[groupK];

        for (int i = 0; i < groupK; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < k; j++) {
                int idx = i * k + j;
                if (idx < s.length()) {
                    sb.append(s.charAt(idx));
                } else {
                    sb.append(fill);
                }
            }
            res[i] = sb.toString();
        }
        return res;
    }
}

/*
class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> ans = new ArrayList<>();
        while (s.length() % k != 0) {
            s += fill;
        }
        StringBuilder cur = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            cur.append(s.charAt(i));
            if (cur.length() == k) {
                ans.add(cur.toString());
                cur = new StringBuilder();
            }
        }
        return ans.toArray(new String[0]);
    }
}
*/