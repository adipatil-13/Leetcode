class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            set.add(validEmail(email));
        }
        return set.size();
    }
    private String validEmail(String email) {
        StringBuilder sb = new StringBuilder();

        int idx = email.indexOf('@');
        
        for (int i = 0; i < idx; i++) {
            char ch = email.charAt(i);
            if (ch == '.') continue;
            if (ch == '+') break;
            else sb.append(ch);
        }

        sb.append(email.substring(idx));
        return sb.toString();
    }
}