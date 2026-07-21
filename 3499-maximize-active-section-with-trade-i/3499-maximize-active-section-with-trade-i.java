class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        int maxZeroMerge = 0;
        int currentZeroGroup = 0;
        List<Integer> zeroGroupLengths = new ArrayList<>();

        // Step 1: Count total ones and identify lengths of zero blocks
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                currentZeroGroup++;
            } else {
                totalOnes++;
                if (currentZeroGroup > 0) {
                    zeroGroupLengths.add(currentZeroGroup);
                    currentZeroGroup = 0;
                }
            }
        }
        if (currentZeroGroup > 0) {
            zeroGroupLengths.add(currentZeroGroup);
        }

        // Step 2: Find the maximum sum of any two adjacent zero groups
        for (int i = 0; i < zeroGroupLengths.size() - 1; ++i) {
            int currentMerge = zeroGroupLengths.get(i) + zeroGroupLengths.get(i + 1);
            maxZeroMerge = Math.max(maxZeroMerge, currentMerge);
        }

        // Step 3: Total active sections are the initial ones plus the merged zeros
        return totalOnes + maxZeroMerge;
    }
}
