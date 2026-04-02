class Solution {
    public int lengthOfLastWord(String s) {
        String[] r=s.split(" ");
        int l=r.length-1;
        return r[l].length();
    }
}