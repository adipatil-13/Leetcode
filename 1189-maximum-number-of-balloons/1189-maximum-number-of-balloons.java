class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
        }

        int max = Math.min(map.get('b'), 
                Math.min(map.get('a'), 
                Math.min(map.get('n'), 
                Math.min(map.get('o') / 2, map.get('l') / 2))));
        return max;
    }
}