class Solution {
    private boolean canRun(int n, int[] batteries, long targetTime){
        long totalUsablePower = 0;
        for(int battery : batteries){
            totalUsablePower += Math.min(battery, targetTime);
        }
        return totalUsablePower >= (long) n * targetTime;
    }
    public long maxRunTime(int n, int[] batteries) {
        long low = 0;
        long high = 0;

        for(int battery : batteries){
            high += battery;
        }
        long ans = 0;

        while(low <= high){
            long mid = low + (high - low) / 2;

            if(canRun(n, batteries, mid)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
}