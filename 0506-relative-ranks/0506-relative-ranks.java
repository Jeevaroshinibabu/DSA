class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        
       
        int maxScore = 0;
        for (int s : score) {
            if (s > maxScore) {
                maxScore = s;
            }
        }
        
   
        int[] athleteIndex = new int[maxScore + 1];
        for (int i = 0; i < n; i++) {
            athleteIndex[score[i]] = i + 1; 
        }
        
       
        int currentRank = 1;
        for (int s = maxScore; s >= 0; s--) {
            if (athleteIndex[s] > 0) { 
                int originalIndex = athleteIndex[s] - 1;
               
                if (currentRank == 1) {
                    result[originalIndex] = "Gold Medal";
                } else if (currentRank == 2) {
                    result[originalIndex] = "Silver Medal";
                } else if (currentRank == 3) {
                    result[originalIndex] = "Bronze Medal";
                } else {
                    result[originalIndex] = String.valueOf(currentRank);
                }
                
                currentRank++; 
            }
        }
        
        return result;
    }
}
