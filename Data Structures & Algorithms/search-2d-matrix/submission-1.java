class Solution {
    /*
    Better Approach O(m*log(n))
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
    */

    // Optimal Approach ( instead of this consider entire array as 1D array) O (log(m*n))
public boolean searchMatrix(int[][] matrix, int target) {

    int m = matrix.length;
    int n = matrix[0].length;

    int right = m*n-1;
    int left = 0;

    while(left<=right){
        int mid = left + (right - left)/2;

        int row = mid/n;
        int col = mid % n;

        if(matrix[row][col]==target){
            return true;
        }else if(matrix[row][col]<target){
            left = mid+1;
        }else{
            right = mid - 1;
        }
    }
    return false;
}

}
