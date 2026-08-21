class Solution {
    public int maxArea(int[] heights) {
        int left =0,right=heights.length-1;
        int maxWater = 0;
        while(left<right){
            int min = Math.min(heights[left], heights[right]);
            int width = right-left;
            int val = min*width;
            maxWater = Math.max(maxWater, val);

            if(heights[left]<heights[right]) left++;
            else right--;
        }

        return maxWater;
    }
}
