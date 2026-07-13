import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String allDigits = "123456789";
        
        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();
        
        for (int length = lowLength; length <= highLength; length++) {
           
            for (int start = 0; start + length <= 9; start++) {
                String substring = allDigits.substring(start, start + length);
                int num = Integer.parseInt(substring);
                
               
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        return result;
    }
}
