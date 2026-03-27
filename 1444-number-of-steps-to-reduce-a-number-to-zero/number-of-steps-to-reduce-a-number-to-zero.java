class Solution {
    public int numberOfSteps(int num) {
        int c=0;
        while(num>0&&num>0){
            if(num%2!=0){
                num-=1;
                c+=1;
            }
            if(num%2==0&&num>0){
            num=num/2;
            c+=1;}
        }
        return c;
    }
}