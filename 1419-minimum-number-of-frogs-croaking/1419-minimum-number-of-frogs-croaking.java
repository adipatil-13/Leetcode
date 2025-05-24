class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0, in_use = 0, res = 0;

        for (char ch : croakOfFrogs.toCharArray()) {
            switch(ch) {
                case 'c':
                    c++;
                    in_use++;
                    break;
                case 'r':
                    r++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'k':
                    k++;
                    in_use--;
                    break;
            }
            res = Math.max(res, in_use);
            if ((c < r) || (r < o) || (o < a) || (a < k)) return -1;
        }
        if (in_use == 0 && c == r && c == o && c == a && c == k) return res;
        return -1;
    }
}
/*
public int minNumberOfFrogs(String croakOfFrogs) {
	int[] letterCounts = new int[26]; 
	int count = 0;
	int maxCount = 0;
	
	for (char c : croakOfFrogs.toCharArray()) {
		letterCounts[c - 'a'] ++; 

		if (c == 'c') { // left boundary
			count++;
			maxCount = Math.max(maxCount, count);
		} else {
			if (!isValid(c, letterCounts)) return -1; 
			if (c == 'k') { // right boundary 
				count--;
			}
		}
	}
	return count == 0 ? maxCount : -1;
}

private boolean isValid(char c, int[] counts) {
	char prevChar;
	if (c == 'r') prevChar = 'c';
	else if (c == 'o') prevChar = 'r';
	else if (c == 'a') prevChar = 'o';
	else prevChar = 'a'; 

	return counts[prevChar - 'a'] >= counts[c - 'a']; 
}
*/