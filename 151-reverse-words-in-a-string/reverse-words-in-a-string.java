class Solution {
    public String reverseWords(String s) {
        String[] r = s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=r.length-1;i>=0;i--){
            sb.append(r[i]);
            if(i>0){
            sb.append(" ");}
        }
        return sb.toString(); 
    }
}