class Solution {
    public String reversePrefix(String word, char ch) {
        Stack<Character> st=new Stack<>();
        int l=0;
        if(word.contains(String.valueOf(ch))){
        while(l<word.length()){
         if(word.charAt(l)!=ch){
            st.push(word.charAt(l));
            l++;
         }else if(word.charAt(l)==ch){
            st.push(word.charAt(l));
            l++;
            break;
         }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        for(int i=l;i<word.length();i++){
            sb.append(word.charAt(i));
        }
        return sb.toString();}else{
            return word;
        }
    }
}