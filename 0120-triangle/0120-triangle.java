class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] front = new int[n];
        int[] cur = new int[n];

        for (int j = 0; j < n; j++) 
            front[j] = triangle.get(n - 1).get(j);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = triangle.get(i).get(j) + front[j];
                int diagonal = triangle.get(i).get(j) + front[j + 1];
                cur[j] = Math.min(down, diagonal);
            }
            front = cur.clone();
        }
        return front[0];
    }
}