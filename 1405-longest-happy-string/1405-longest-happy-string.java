class Solution {
    public String longestDiverseString(int a, int b, int c) {

        Queue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[1] - x[1]);
      
        if (a > 0) {
            maxHeap.offer(new int[] {'a', a});
        }
        if (b > 0) {
            maxHeap.offer(new int[] {'b', b});
        }
        if (c > 0) {
            maxHeap.offer(new int[] {'c', c});
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {

            int[] mostFrequent = maxHeap.poll();
            int resultLength = result.length();
          

            if (resultLength >= 2 && 
                result.codePointAt(resultLength - 1) == mostFrequent[0] && 
                result.codePointAt(resultLength - 2) == mostFrequent[0]) {
              
                if (maxHeap.isEmpty()) {

                    break;
                }
              

                int[] secondMostFrequent = maxHeap.poll();
                result.append((char) secondMostFrequent[0]);
              

                if (secondMostFrequent[1] > 1) {
                    secondMostFrequent[1]--;
                    maxHeap.offer(secondMostFrequent);
                }

                maxHeap.offer(mostFrequent);
            } else {

                result.append((char) mostFrequent[0]);

                if (mostFrequent[1] > 1) {
                    mostFrequent[1]--;
                    maxHeap.offer(mostFrequent);
                }
            }
        }

        return result.toString();
    }
}