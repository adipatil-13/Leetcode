class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<>();

        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
        set.remove(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.peek().str;
            int steps = queue.peek().counter;

            queue.remove();
            if (word.equals(endWord)) return steps; 

            for (int i = 0; i < word.length(); i++) {
                char[] temp = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    temp[i] = c; 
                    
                    String newWord = new String(temp);

                    if (set.contains(newWord)) {
                        queue.add(new Pair(newWord, steps + 1));
                        set.remove(newWord); //Prevent revisiting
                    }
                }
            }
        }
        return 0;
    }
}
class Pair {
    String str;
    int counter;
    Pair (String _str, int _counter) {
        this.str = _str;
        this.counter = _counter;
    } 
}