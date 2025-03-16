class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();

        firstRow.add(1);
        triangle.add(firstRow);

        triangle = generateRows(triangle, numRows);
        return triangle;
    }
    public List<List<Integer>> generateRows(List<List<Integer>> triangle, int maxRows) {
        if (triangle.size() >= maxRows) {
            return triangle;
        }
        
        List<Integer> newRow = new ArrayList<>();
        List<Integer> previousRow = triangle.get(triangle.size() - 1);
        
        newRow.add(1);
        for (int i = 1; i < previousRow.size(); i++) {
            newRow.add(previousRow.get(i - 1) + previousRow.get(i));
        }
        newRow.add(1);

        triangle.add(newRow);
        triangle = generateRows(triangle, maxRows);

        return triangle;
    }
}
