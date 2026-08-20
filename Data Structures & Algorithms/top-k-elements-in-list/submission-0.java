class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        // 1. Count frequencies
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. Create buckets
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        // 3. Put numbers into bucket based on frequency
        for (int key : freqMap.keySet()) {
            int value = freqMap.get(key);

            if (bucket[value] == null) {
                bucket[value] = new ArrayList<>();
            }

            bucket[value].add(key);
        }

        // 4. Traverse from highest frequency to lowest
        int counter = 0;
        int[] ans = new int[k];

        for (int i = bucket.length - 1; i >= 0 && counter < k; i--) {

            if (bucket[i] != null) {

                for (int j = 0; j < bucket[i].size() && counter < k; j++) {
                    ans[counter++] = bucket[i].get(j);
                }
            }
        }

        return ans;
    }
}