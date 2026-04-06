class Solution {
    public String removeStars(String s) {
        Stack <Character> st=new Stack<>();;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='*'){
            st.push(s.charAt(i));
            }
            if(s.charAt(i)=='*'){
                st.pop();
            }
            }
          String result = st.stream()
                     .map(Object::toString)
                     .collect(Collectors.joining("")); 
            return result;
    }
}
