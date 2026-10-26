class Solution {
    private boolean isPossible(int[] piles, int h, int k){
        long totalHours = 0;
        for(int pile : piles){
            totalHours += (pile + k - 1) / k;
        }
        return totalHours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int pile : piles){
            high = Math.max(high, pile);
        }
        while(low < high){
            int mid = low + (high - low) / 2;
            if(isPossible(piles, h, mid)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}