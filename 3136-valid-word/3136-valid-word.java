class Solution {
    public boolean isValid(String word) {
        boolean vowel = false, consonant = false;
        if (word.length() < 3) return false;

        for (char ch : word.toCharArray()) {
           if (Character.isLetter(ch)) {
                if ("aeiouAEIOU".indexOf(ch) != -1) {
                    vowel = true;
                } else {
                    consonant = true;
                }
            } else if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return (vowel && consonant);
    }
}