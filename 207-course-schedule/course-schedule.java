class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> n=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            n.add(new ArrayList<>());
        }
        int[] in =new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            n.get(u).add(v);
            in[v]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                q.add(i);
            }
        }

        int c=0;
        while(!q.isEmpty()){
            int r=q.poll();
            c++;

            for(int e: n.get(r)){
                in[e]--;
                if(in[e]==0){
                    q.add(e);
                }
            }
        }
        return c==numCourses;
    }
}