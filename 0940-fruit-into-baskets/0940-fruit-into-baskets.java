class Solution {
    public int totalFruit(int[] fruits) {
        int i=0,j=0,max=0;
        HashMap<Integer,Integer>hm=new HashMap<>();
        while(i<fruits.length){
            hm.put(fruits[i],hm.getOrDefault(fruits[i],0)+1);
            if(hm.size()>2){
                while(hm.size()>2){
                    hm.put(fruits[j],hm.get(fruits[j])-1);
                    if(hm.get(fruits[j])==0){
                        hm.remove(fruits[j]);
                    }
                    j++;
                }
            }
            else{
                max=Math.max(max,i-j+1);
            }
            i++;
        }
        return max;
    }
}