class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            int current = n;
            int product = 1;
            
        
            while (current > 0) {
                product *= (current % 10);
                current /= 10;
            }
            
            
            if (product % t == 0) {
                return n;
            }
            
            n++; 
        }
    }
}
