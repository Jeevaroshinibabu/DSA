int countPrimes(int n) {
    bool *prime=calloc(n,sizeof(bool));
    int result=0;
    for(int i=2;i<n;i++){
        if(prime[i]==false){
            result++;
            for(int j=i;j<n;j+=i) prime[j]=true;
        }
    }
    return result;
}