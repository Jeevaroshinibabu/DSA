int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
    if(numOnes>k) return k;
    else{
        if(k>numOnes) {
            if(k-numOnes==0) return numOnes;
            else{
                int j=k-numOnes;
                if(j-numZeros==0||j-numZeros<0)return numOnes;
                else if(numNegOnes==0) return numOnes;
                else{
                    int l=j-numZeros;
                    return numOnes-l;
                }
            }
        }
    
    return numOnes;}
}