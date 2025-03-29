class Solution {
    public int romanToInt(String s) {
        int res = 0, num = 0, prev = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            switch(s.charAt(i)){
                case 'M': num = 1000; break;
                case 'D': num = 500; break;
                case 'C': num = 100; break;
                case 'L': num = 50; break;
                case 'X': num = 10; break;
                case 'V': num = 5; break;
                case 'I': num = 1; break;
            }

            if(num < prev){
                res -= num;
            } else {
                res += num;
            }
            prev = num;
        }
        return res;

    }
}