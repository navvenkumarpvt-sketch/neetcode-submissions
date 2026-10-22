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
 // EG : matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15
    int m = matrix.length; // 3
    int n = matrix[0].length; // 4

    int right = m*n-1; // (4*3)-1 => 11
    int left = 0;

    while(left<=right){ // 0<= 11 (true), 2.1<=11(true) 3.9<=12(true) 4.9<=9(true) 5.9<=8 (false ) exit loop and return false
        int mid = left + (right - left)/2; 
        // 0 + (11-0)/2 => 5, 2.6+(11-6)/2=>8 3.9+(12-9)/2 => 10 4.9+(9-9)/2=> 9

        int row = mid/n; // 5/4 => 1 2.8/4 => 2 3.10/4=> 2 4.9/4=>2
        int col = mid%n; // 5%4 => 1 2.8%4 => 0 3.10%4=> 2 4. 9%4=>1

        if(matrix[row][col]==target){ 
            // 11==15 (false) 2.14==15 (false) 3.30==15 (false) 4.20==15 (false)
            return true;
        }else if(matrix[row][col]<target){
            // 11<15 (true) 2.14<15 (true) 3.30<15 (false) 4.20<15 (false)
            left = mid+1; // left = 6 2.left = 8+1=>9
        }else{
            right = mid - 1; // 3.right = 10-1=>9 4.right = 9-1=> 8
        }
    }
    return false;
}

}
