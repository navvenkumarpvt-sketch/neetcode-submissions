class Solution {
    public int longestConsecutive(int[] nums) {


// BRUTE FORCE ( O(nLog(n))) time , space :O(1)
        // if(nums.length==0) return 0;


        // Arrays.sort(nums);

        // int count =1,maxCount =1;
        // for(int i=1;i<nums.length;i++){
        //     int diff = nums[i]-nums[i-1];
        //     if(diff==1){
        //         maxCount = Math.max(++count, maxCount);
        //     }else if(nums[i]!=nums[i-1]){
        //         count =1;
        //     }
        // }
        // return maxCount;


        // Optimal:
        // use hashset and look for starting element and start it from there.

        if(nums.length==0 || nums==null) return 0;

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
            }
        }

        int maxLength = 1;

        for(int num : nums){
            if(!set.contains(num-1)){
                int startEle = num;
                int currentLen = 1;

                while(set.contains(startEle+1)){
                    startEle++;
                    currentLen++;
                }

                maxLength = Math.max(currentLen, maxLength);
            }
        }

        return maxLength;

    }
}
