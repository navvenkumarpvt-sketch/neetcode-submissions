class Solution {
        public int trap(int[] height) {

        int n = height.length;
        if(n==0 || height == null) return 0;

        int[] leftMaxArr = new int[n];
        int[] rightMaxArr = new int[n];

        leftMaxArr[0] = height[0];

        for(int i=1;i<n;i++){
        leftMaxArr[i] = Math.max(leftMaxArr[i-1], height[i]);
        }

        rightMaxArr[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
        rightMaxArr[i] = Math.max(rightMaxArr[i+1], height[i]);
        }

        int result = 0;
        for(int i=0;i<n-1;i++){
        result+= Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }

        return result;
        
    }
}
