class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        StringBuilder sb = new StringBuilder();
        String[] words = s.split("\\s+");
        

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

/*
        String[] words = s.split(" ");
        int left = 0, right = words.length - 1;

        while(left < right){
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        StringBuilder res = new StringBuilder();
        for(String word : words){
            if(!word.isEmpty()){
                if(res.length() > 0){
                    res.append(" ");
                }
                res.append(word);
            }
        }
        return res.toString();
*/
