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
          String result = "";
          while(!st.isEmpty()){
            result+=st.pop();
          }
          String r="";
          for(int i=result.length()-1;i>=0;i--){
            r+=result.charAt(i);
          }
            return r;
    }
}
