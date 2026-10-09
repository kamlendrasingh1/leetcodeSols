class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < nums.length; i++){
            minHeap.offer(new int[]{nums[i], i});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        Set<Integer> idx = new HashSet<>();
        while(!minHeap.isEmpty()){
            idx.add(minHeap.poll()[1]);
        }
        int[] result = new int[k];
        int rIdx = 0;
        for(int i = 0; i < nums.length; i++){
            if(idx.contains(i)){
                result[rIdx] = nums[i];
                rIdx = rIdx + 1;
            }
        }
        return result;
    }
}