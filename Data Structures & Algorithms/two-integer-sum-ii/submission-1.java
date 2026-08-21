class Solution {
    // Brute Force time : O(n^2) space : O(1)
    public int[] twoSum(int[] numbers, int target) {
    //     for(int i=0;i<numbers.length-1;i++){
    //         for(int j=i+1;j<numbers.length;j++){
    //             if(numbers[i]+numbers[j]==target){
    //                 return new int[] {i+1, j+1};
    //             }
    //         }
    //     }
    //     return new int[]{-1, -1};
    // }

    //Optimal : Time O(n), space O(1)

    int left =0, right =numbers.length-1;
    while(left<right){
        int sum = numbers[left]+numbers[right];
        if(sum==target) return new int[] {++left, ++right};
        else if(sum>target){
            right--;
        }else{
            left++;
        }
    }
    return new int[] {-1, -1};

}
}
