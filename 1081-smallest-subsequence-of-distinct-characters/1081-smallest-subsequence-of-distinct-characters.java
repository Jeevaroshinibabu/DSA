class Solution {
    public String smallestSubsequence(String s) {
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        boolean[] inStack = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';

            if (inStack[idx]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && lastOccurrence[stack.peek() - 'a'] > i) {
                char removed = stack.pop();
                inStack[removed - 'a'] = false;
            }

            stack.push(c);
            inStack[idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}
