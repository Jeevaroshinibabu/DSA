class Solution {
    public long sumAndMultiply(int n) {
       long concatenatedNoZeros = 0;
        long digitSum = 0;
        long multiplier = 1;

        while (n > 0) {
            int digit = n % 10;
            digitSum += digit; 

            if (digit > 0) {
                
                concatenatedNoZeros += digit * multiplier;
                multiplier *= 10;
            }
            n /= 10;
        }

        return concatenatedNoZeros * digitSum;
    }
}