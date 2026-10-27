class Solution {
        private long getSum(long a, long count){
        if(count == 0){
            return 0;
        }
        if(a - 1 >= count){
            return (2 * a - 1 - count) * count / 2;
        }else{
            long one = count - (a - 1);
            return (a - 1) * a / 2 + one;
        }
    }
    private boolean isPossible(int n, int idx, long a, int maxSum){
        long left = idx;
        long right = n - 1 - idx;

        long sum = a;
        sum += getSum(a, right);
        sum += getSum(a, left);

        return sum <= maxSum;
    }
    public int maxValue(int n, int index, int maxSum) {
        long low = 1;
        long high = maxSum;
        long res = 1;

        while(low <= high){
            long mid = low + (high - low) / 2;
            if(isPossible(n, index, mid, maxSum)){
                res = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return (int) res;
    }
}