class Solution {
    public int[] dailyTemperatures(int[] temp) {
       Stack <Integer> n=new Stack<>();
       int [] a= new int[temp.length];
       for(int i=a.length-1;i>=0;i--){
         while(!n.isEmpty()&&temp[i]>=temp[n.peek()]){
            n.pop();
         }
         if(n.isEmpty()){
            a[i]=0;
         }
         else{
            a[i]=n.peek()-i;
         }
         n.push(i);
       }
       return a;
    }
}