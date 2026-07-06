class Solution {
    public int[][] merge(int[][] intervals) {
       
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
      
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (list.isEmpty() || list.get(list.size() - 1)[1] < current[0]) {
                list.add(current); 
            } 
            else {
                int[] lastSaved = list.get(list.size() - 1);
                lastSaved[1] = Math.max(lastSaved[1], current[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
