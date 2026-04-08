class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int r=image.length;
        for(int i=0;i<image.length;i++){
            for(int j=0 ;j<(r+1)/2 ;j++){
                int n=image.length-1;;
                 int t=image[i][j];
                 image[i][j]=image[i][n-j];
                 image[i][n-j]=t;
            }
        }
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(image[i][j]==0){
                    image[i][j]=1;
                }else{
                    image[i][j]=0;
                }
            }
        }
        return image;
    }
}