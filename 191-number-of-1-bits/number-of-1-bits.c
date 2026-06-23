int hammingWeight(int n) {
    int co = 0;
        while (n != 0) {
            int dig = n % 2;
            if (dig == 1) co++;
            n /= 2;
        }
        return co;
}