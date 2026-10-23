class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int max = 0;
        for(int pile :piles){
            max = Math.max(max, pile);
        }

        while(low<max){
            int mid = low + (max-low)/2;
            if(canKokoEatBanana(piles, h, mid)){
                max = mid;
            }else{
                low = mid+1;
            }
        }

        return max;
    }

    private boolean canKokoEatBanana(int[] piles, int time, int mid){

        int hours = 0;
        for(int pile: piles){
            hours+= (int) Math.ceil((double) pile/mid);
        }
        return hours<=time;
    }
}
