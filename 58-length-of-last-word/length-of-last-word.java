class Solution {
    public int lengthOfLastWord(String s) {
        String[] r=s.split(" ");
        return r[r.length-1].length();
    }
}