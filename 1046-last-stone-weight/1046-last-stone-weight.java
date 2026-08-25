class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while(maxHeap.size() > 1){
            int largest = maxHeap.poll();
            int secondLargest = maxHeap.poll();

            if(largest != secondLargest){
                maxHeap.offer(largest - secondLargest);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}