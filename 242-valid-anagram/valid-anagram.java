class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> h= new HashMap<>();
        for(int i=0;i<s.length();i++){
            char charS = s.charAt(i);
            h.put(charS, h.getOrDefault(charS, 0) + 1);
        }
       HashMap<Character,Integer> g= new HashMap<>();
       for(int i=0;i<t.length();i++){
            char charT = t.charAt(i);
            g.put(charT, g.getOrDefault(charT, 0) + 1);
        }
        if(h.equals(g)){
            return true;
        }else{
            return false;
        }
    }
}