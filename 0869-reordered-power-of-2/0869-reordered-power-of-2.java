class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] s1 = Integer.toString(n).toCharArray();
        Arrays.sort(s1);
        String s1Sorted = new String(s1);

        for (int i = 1; i <= 1_000_000_000; i *= 2) {
            char[] s2 = Integer.toString(i).toCharArray();
            Arrays.sort(s2);
            
          
            if (s1Sorted.equals(new String(s2))) {
                return true;
            }
        }

        return false;
    }
}