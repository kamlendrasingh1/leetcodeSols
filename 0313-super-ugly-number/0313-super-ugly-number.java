class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(1);
        int currentNumber = 0;

        while(n-- > 0){
            currentNumber = minHeap.poll();
            while(!minHeap.isEmpty() && minHeap.peek() == currentNumber){
                minHeap.poll();
            }
            for(int prime : primes){
                if(prime <= Integer.MAX_VALUE / currentNumber){
                    minHeap.offer(prime * currentNumber);
                }
                if(currentNumber % prime == 0){
                    break;
                }
            }
        }
        return currentNumber;
    }
}