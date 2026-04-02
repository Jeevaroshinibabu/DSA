class Solution {
    public String capitalizeTitle(String title) {
        title=title.toLowerCase();
        String[] n=title.split(" ");
        for(int i=0;i<n.length;i++){
            if(n[i].length()>2){
                   n[i] = n[i].substring(0, 1).toUpperCase() + n[i].substring(1);
            }
        }
        String r=String.join(" ",n);
        return r;
    }
}