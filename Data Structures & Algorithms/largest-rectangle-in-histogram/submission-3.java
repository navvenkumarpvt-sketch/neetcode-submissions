class Solution {
    public int largestRectangleArea(int[] heights) {
        /*
        BRUTE FORCE : O(n^2) worst case
        int maxArea =0,left=0,right=0;
        for(int i=0;i<heights.length;i++){
            int minHeight = heights[i];
            left = i;
            right=i;
            while(left>0 && heights[left-1]>=minHeight){
                left--;
            }
            while(right<heights.length-1 && heights[right+1]>=minHeight){
                right++;
            }

            int width = right-left+1;
            int area = minHeight * width;
            maxArea = Math.max(maxArea, area);

        }
        return maxArea;
        */
                int n = heights.length;

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() &&
                   heights[stack.peek()] >= currHeight) {

                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return maxArea;
    }
}
