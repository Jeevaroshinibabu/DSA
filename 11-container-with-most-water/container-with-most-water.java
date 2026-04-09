class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1,m=0;
        while(l<r){
          int c=Math.min(height[l],height[r]);
          int h=r-l;
          int a=c*h;
          m=Math.max(m,a);
          if(height[l]<height[r]){
            l++;
          }else{
            r--;
          }
    }
    return m;
    }
}