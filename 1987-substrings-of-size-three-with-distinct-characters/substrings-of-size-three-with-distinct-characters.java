
class Solution {
    public int countGoodSubstrings(String s) {
        HashMap<Character,Integer> h=new HashMap<>();
        int l=0,c=0,k=3;
    for(int i=0;i<s.length();i++){
        char a=s.charAt(i);
        h.put(a,h.getOrDefault(a, 0) + 1);
        if(i-l+1==k){
            if(h.size()==3){
                c++;
            }
            char charl=s.charAt(l);
            h.put(charl, h.get(charl) - 1);
            if(h.get(charl)==0){
            h.remove(charl);}
            l++;
        }
    }
    return c;
         
    }
}