class Solution {
    public int lengthOfLongestSubstring(String s) {
        int m=0,l=0;
        HashMap<Character,Integer> h=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char r=s.charAt(i);
            h.put(r,h.getOrDefault(r,0)+1);
            
               while(h.get(r)>1){
                char o = s.charAt(l);
                h.put(o,h.get(o)-1);
                l++;
               } 
               m=Math.max(m,i-l+1);
            
        }
        return m;
    }
}