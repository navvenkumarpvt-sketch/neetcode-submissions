class Solution {
    public int search(int[] nums, int target) {
        // nums=[4,5,6,7,0,1,2]
        // target=0
        int left=0,right=nums.length-1; // left=0, right=6
        while(left<=right){//0<=6(true) 2.4<=6 (true)
            int mid = left +(right-left)/2; // mid=0+(6-0)/2=>3 2.4+(6-4)/2=>5
            if(nums[mid]==target){// 7==0 (false) 2.
                return mid;
            }

            if(nums[left]<=nums[mid]){
                if(nums[left]<=target && target<nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[right]>=target && target>nums[mid]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
