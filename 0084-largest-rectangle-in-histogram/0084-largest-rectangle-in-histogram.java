class Solution {
    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer> st = new LinkedList<>();
        int maxArea=0;
        int n=heights.length;
        for(int i=0;i<=n;i++){
            if(st.isEmpty()){
                st.push(i);
            }else{
                while(!st.isEmpty()&&(i==n||heights[st.peek()]>=heights[i])){
                    int height=heights[st.pop()];
                    int leftIndex=-1;
                    int rightIndex=i;
                    if(!st.isEmpty()){
                        leftIndex=st.peek();
                    }
                    int width=rightIndex-leftIndex-1;
                    int area=width*height;
                    maxArea=Math.max(area,maxArea);
                }
                st.push(i);
            }
        }
        return maxArea;
    }
}