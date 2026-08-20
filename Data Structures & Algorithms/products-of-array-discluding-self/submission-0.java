class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Store left products in result
        result[0] = 1;

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Multiply by right products
        int rightPrd = 1;

        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightPrd;
            rightPrd = rightPrd * nums[i];
        }

        return result;
    }
}

