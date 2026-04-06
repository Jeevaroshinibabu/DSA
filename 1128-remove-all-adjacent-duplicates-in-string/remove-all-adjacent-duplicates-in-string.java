class Solution {
    public String removeDuplicates(String s) {
        Stack <Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char r=s.charAt(i);
            if(!st.isEmpty()&&r==st.peek()){
                st.pop();
            }else{
                st.push(r);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
           sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}