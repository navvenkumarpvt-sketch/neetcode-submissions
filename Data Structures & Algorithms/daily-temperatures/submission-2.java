class Solution {

    // BRUTE Force : O(N^2)
    /*
    public int[] dailyTemperatures(int[] temperatures) {
       int[] output = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int j=i;
            int out = nextGreaterTemp(temperatures, temperatures[i], j);
            output[i] = out==0 ? 0:out-i;
        }
        return output;
    }

    private int nextGreaterTemp(int[] arr, int currentValue, int start){
        int output = 0;
        for(int i=start;i<arr.length;i++){
            if(arr[i]>currentValue){
                output = i;
                break;
            }
        }
        return output;
    }
    
    */

    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] output = new int[n];

        for(int i=n-1;i>=0;i--){
            int currElement = arr[i];

            while(!stack.isEmpty() && (arr[stack.peek()]<=currElement)){
                stack.pop();
            }

            if(!stack.isEmpty()){
                output[i] = stack.peek()-i;
            }

            stack.push(i);
        }
        return output;
    }

}
