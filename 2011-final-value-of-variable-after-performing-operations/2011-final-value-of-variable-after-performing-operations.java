class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String op : operations) {
            if (op.indexOf('+') != -1) res++;
            if (op.indexOf('-') != -1) res--;
        }
        return res;
    }
}