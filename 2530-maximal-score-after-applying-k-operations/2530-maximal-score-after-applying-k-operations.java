class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums){
            maxHeap.offer(num);
        }

        long score = 0;

        while(k > 0){
            int maxVal = maxHeap.poll();
            score += maxVal;
            int nextVal = (maxVal + 2) / 3;
            maxHeap.offer(nextVal);
            k--;
        }
        return score;
    }
}