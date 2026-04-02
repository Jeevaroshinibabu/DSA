class Solution {
    public boolean isSubsequence(String s, String t) {
        int j=0,i=0;
        while(i<t.length()&&j<s.length()){
            char cs=s.charAt(j);
            char ct=t.charAt(i);
            if(ct==cs){
                j++;
            }
            i++;
        }
        if(j==s.length()){
            return true;
        }else{
            return false;
        }
    }
}