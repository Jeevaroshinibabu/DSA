class Solution {
    public int longestValidParentheses(String s) {
        char[] str=s.toCharArray();
        Stack<Integer> q=new Stack<>();
        int c=0;
        q.push(-1);
        for(int i=0;i<str.length;i++){
            if(str[i]=='('){
                q.push(i);
            }else{
                q.pop();
                if(q.isEmpty()){
                q.push(i);
                }else{
                c=Math.max(c,i-q.peek());
                }
            }
        }
        return c;
    }
}