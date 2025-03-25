class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        String[] words = s.split(" ");
        int n = words.length;
        
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            if (words[i].trim() != ""){
                sb.append(words[i]);

                if (i != 0) sb.append(" ");
            }
        }
        return sb.toString();
    }
}