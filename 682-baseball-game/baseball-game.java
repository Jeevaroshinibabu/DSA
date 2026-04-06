class Solution {
    public int calPoints(String[] operations) {
        Stack <Integer> st=new Stack<>();
        for(String op: operations){
            if(op.equals("C")){
                st.pop();
            }else if(op.equals("D")){
                st.push(st.peek()*2);
            }else if(op.equals("+")){
                int top=st.pop();
                int nt=st.peek();
                st.push(top);
                st.push(top+nt);

            }else{
                st.push(Integer.parseInt(op));
            }
        }
        int c=0;
        while(!st.isEmpty()){
            c+=st.pop();
        }
        return c;
    }
}