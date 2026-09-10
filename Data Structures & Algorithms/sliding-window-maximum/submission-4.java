class Solution {
public int[] maxSlidingWindow(int[] nums, int k) {

    
    // Brute force ( O(n*k) or O(n^2) in worst case where k==n)

//     int max = Integer.MIN_VALUE;

//     // First window: [0, k-1]
//     for (int i = 0; i < k; i++) {
//         max = Math.max(max, nums[i]);
//     }

//     int[] res = new int[nums.length - k + 1];

//     res[0] = max;

//     int left = 1;
//     int right = k;

//     // Each new window: [left, right]
//     while (right < nums.length) {
//         res[left] = findMaxInWindow(nums, left, right);

//         left++;
//         right++;
//     }

//     return res;
// }

// private int findMaxInWindow(int[] arr, int left, int right) {
//     int max = Integer.MIN_VALUE;

//     for (int i = left; i <= right; i++) {
//         max = Math.max(max, arr[i]);
//     }

//     return max;
// }

int[] result = new int[nums.length-k+1];
Deque<Integer> dq = new ArrayDeque<>();

for(int i=0;i<k;i++){

    while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
        dq.pollLast();
    }

    dq.addLast(i);
}

for(int i=k;i<nums.length;i++){

    result[i-k] = nums[dq.peekFirst()];

    while(!dq.isEmpty() && dq.peekFirst()<=i-k){
        dq.pollFirst();
    }



    while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()]){
        dq.pollLast();
    }

    dq.addLast(i);
}

result[nums.length-k] = (nums[dq.pollFirst()]);

return result;

}
}
