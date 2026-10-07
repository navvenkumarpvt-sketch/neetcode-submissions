class Solution {
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

}
