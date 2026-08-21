class Solution {
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    
    // Step 1: Sort the array (Crucial for the two-pointer approach)
    Arrays.sort(nums);

    // Step 2: Loop through each number, treating it as our first element (nums[i])
    for (int i = 0; i < nums.length - 2; i++) {
        // Skip duplicate values for 'i' to avoid duplicate triplets in the output
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }

        // Step 3: Set up two pointers for the remaining portion of the array
        int k = i + 1;
        int end = nums.length - 1;

        while (k < end) {
            int sum = nums[i] + nums[k] + nums[end];

            if (sum == 0) {
                // Found a valid triplet! Add the values to a list
                output.add(Arrays.asList(nums[i], nums[k], nums[end]));

                // Move pointers past any duplicates for k and end
                while (k < end && nums[k] == nums[k + 1]) k++;
                while (k < end && nums[end] == nums[end - 1]) end--;

                // Move inward to find new potential triplets
                k++;
                end--;
            } 
            else if (sum < 0) {
                // Sum is too small, move the left pointer up to get a larger number
                k++;
            } 
            else {
                // Sum is too large, move the right pointer down to get a smaller number
                end--;
            }
        }
    }

    return output;
}
}
