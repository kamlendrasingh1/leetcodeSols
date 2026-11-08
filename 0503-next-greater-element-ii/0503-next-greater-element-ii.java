class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n * 2; ++i){
            int num = nums[i % n];
            while(!stack.isEmpty() && nums[stack.peek()] < num){
                ans[stack.pop()] = num;
            }
            if(i < n){
                stack.push(i);
            }
        }
        return ans;
    }
}