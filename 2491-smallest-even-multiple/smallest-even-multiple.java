class Solution {
    public int smallestEvenMultiple(int n) {
        int k=-1;
        for(int i=1;i<n*10000000;i++){
            if(i%2==0 && i%n==0){
                k=i;
                break;
            }
        }
       return k;
    }
}