class Solution {
    public boolean isCircularSentence(String sentence) {

        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            return false;
        }

        int idx = sentence.indexOf(" ");

        if (idx == -1) return true;

        while (idx != -1) {
            if (sentence.charAt(idx - 1) != sentence.charAt(idx + 1)) return false;
            idx = sentence.indexOf(" ", idx + 1);
        }
        return true;
    }
}