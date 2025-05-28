class Solution {
    public boolean makeEqual(String[] words) {
        if (words.length == 1) {
			return true;
		}
		int totalChar = 0;
		for (String s : words) {
			totalChar += s.length();
		}
		if (totalChar % words.length != 0) {
			return false;
		}

		int[] freq = new int[26];
		for (String s : words) {
			for (char c : s.toCharArray()) {
				freq[c - 'a']++;
			}
		}
		for (int i : freq) {
			if (i % words.length != 0) {
				return false;
			}
		}
		return true;
    }
}