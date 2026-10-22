class Solution {
    private int[] prefixSum;
    private int totalSum;
    private Random random;

    public Solution(int[] w) {

    this.prefixSum = new int[w.length];
    this.random = new Random();
    
    int sum = 0;
    for(int i = 0; i < w.length; i++){
        sum += w[i];
        this.prefixSum[i] = sum;
    }
    this.totalSum = sum;

    }
    
    public int pickIndex() {
        int target = random.nextInt(totalSum) + 1;

        int low = 0;
        int high = prefixSum.length - 1;

        while(low < high){
            int mid = low + (high - low) / 2;
            if(prefixSum[mid] >= target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */