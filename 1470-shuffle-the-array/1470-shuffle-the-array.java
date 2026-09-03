class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n << 1];
        for(int i = 0, resultIndex = 0; i < n; i++){
            result[resultIndex++] = nums[i];
            result[resultIndex++] = nums[i+n];
        }
        return result;
    }
}