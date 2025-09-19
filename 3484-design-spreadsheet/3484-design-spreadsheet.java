class Spreadsheet {

    private Map<String, Integer> cells = new HashMap<>();
    public Spreadsheet(int rows) {

    }
    
    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }
    
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    
    public int getValue(String formula) { // "=2+3", "=A1+B2"
        int pivot = formula.indexOf('+');
        String left = formula.substring(1, pivot);
        String right = formula.substring(pivot + 1);

        int valLeft = Character.isLetter(left.charAt(0)) ? cells.getOrDefault(left, 0) : Integer.parseInt(left);
        int valRight = Character.isLetter(right.charAt(0)) ? cells.getOrDefault(right, 0) : Integer.parseInt(right);

        return valLeft + valRight;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */