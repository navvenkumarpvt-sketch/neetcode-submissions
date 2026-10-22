class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            int len = matrix[i].length;
            if(matrix[i][len-1]<target){
                continue;
            }else{
                int left = 0, right = len-1;
                while(left<=right){
                    int mid=left + (right-left)/2;
                    if(matrix[i][mid]==target){
                        return true;
                    }else if(matrix[i][mid] < target){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }
            }
        }
        return false;
    }
}
