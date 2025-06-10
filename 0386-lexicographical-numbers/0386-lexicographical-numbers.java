class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            res.add(cnt);

            if (cnt * 10 <= n) {
                cnt *= 10;
            } else {
                if (cnt >= n) cnt /= 10;
                cnt++;
                while (cnt % 10 == 0) cnt /= 10;
            }
        }
        return res;
    }
}