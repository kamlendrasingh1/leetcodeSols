class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> {
            if(nums[a] == nums[b]){
                return Integer.compare(a, b);
            }
            return Integer.compare(nums[a], nums[b]);
        });

        for(int i = 0; i < nums.length; i++){
            pq.offer(i);
        }
        while(k > 0){
            int minIdx = pq.poll();
            nums[minIdx] = nums[minIdx] * multiplier;
            pq.offer(minIdx);
            k = k - 1;
        }
        return nums;
    }
}