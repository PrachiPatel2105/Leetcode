class Solution {
    class pair{
        int val;
        int count;
        pair(int val,int count){
            this.val=val;
            this.count=count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int res[]=new int[k];
        PriorityQueue<pair>pq=new PriorityQueue<>((x,y) -> y.count-x.count);
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i]))
            map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            pq.add(new pair(entry.getKey(),entry.getValue()));
        }
        int index=0;
        while(index<k){
            res[index++]=pq.poll().val;
        }
        return res;
    }
}