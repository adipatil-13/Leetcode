class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeat = new HashSet<>();

        for(int i = 0; i + 9 < s.length(); i++){
            String tenChars = s.substring(i, i + 10);
            if(!seen.add(tenChars)){
                repeat.add(tenChars);
            }
        }
        return new ArrayList(repeat);


    }
}