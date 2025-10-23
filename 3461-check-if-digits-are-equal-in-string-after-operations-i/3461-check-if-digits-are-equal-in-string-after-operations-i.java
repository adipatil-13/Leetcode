class Solution {
    public boolean hasSameDigits(String s) {
        if (s == null || s.length() < 2) return false;
        if (s.length() == 2) return s.charAt(0) == s.charAt(1);
        
        int[] arr = new int[s.length()];

        for (int i = 0; i < arr.length; i++)
            arr[i] = s.charAt(i) - '0';
    
        for (int i = arr.length; i > 2; i--) {
            for (int j = 0; j < i - 1; j++) {
                arr[j] = (arr[j] + arr[j + 1]) % 10;
            }
        }

        return arr[0] == arr[1];
    }
}