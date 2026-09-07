class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long totalSum = 0;

        for(int value : target){
            totalSum += value;
            maxHeap.offer((long) value);
        }
        while(maxHeap.peek() > 1){
            long maxElement = maxHeap.poll();
            long remainingSum = totalSum - maxElement;

            if(remainingSum == 0 || maxElement - remainingSum < 1){
                return false;
            }
            long previousValue = maxElement % remainingSum;

            if(previousValue == 0){
                previousValue = remainingSum;
            }
            maxHeap.offer(previousValue);
            totalSum = totalSum - maxElement + previousValue;
        }
        return true;
    }
}