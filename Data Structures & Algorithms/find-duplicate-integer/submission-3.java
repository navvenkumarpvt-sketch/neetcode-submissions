class Solution {
    public int findDuplicate(int[] nums) {
        // BRUTE FORCE O(n^2)
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             return nums[i];
        //         }
        //     }
        // }
        // return -1;

        // BETTER approach O(n) , space: O(n)
        // Set<Integer> set = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     if(set.contains(nums[i])){
        //         return nums[i];
        //     }
        //     set.add(nums[i]);
        // }
        // return -1;

        

        // OPTIMAL : time O(n) and space O(1) (considering it as linkedList)
        // Floyd's Cycle Detection: Two phases ( you have to consider the existing array as list for example: [1,2,3,2,2] )
        /* 
        [1,2,3,2,2] -> actual array
         0,1,2,3,4 -> indexes

         0      -> 1 (nums[0]) -> 1 (index) -> 2 (value at nums[1]) -> 2 (index) -> 3 (value at nums[2]) - > 3 (index) -> 2 (value at index nums[3]) -> 4(index) - > 2 (value at index nums[4])

        Start at index 0

        Index 0
        |
        | nums[0] = 1
        v
        Index 1
        |
        | nums[1] = 2
        v
        Index 2
        |
        | nums[2] = 3
        v
        Index 3
        |
        | nums[3] = 2
        v
        Index 2
        |
        | nums[2] = 3
        v
        Index 3
        |
        | ...
        */


        // Phase 1 : two pointers slow and fast
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        slow = nums[0];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
