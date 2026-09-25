class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int i = 0; i < matrix.length; i = i + 1){
            minHeap.add(new int[] {
                matrix[i][0],
                i,
                0
            });
        }
        int counter = 1;

        while(!minHeap.isEmpty()){
            int[] ele = minHeap.poll();

            int val = ele[0];
            int listId = ele[1];
            int eleId = ele[2];

            if(counter == k){
                return val;
            }

            counter = counter + 1;

            int nextEleId = eleId + 1;

            if(nextEleId < n){
                minHeap.add(new int[] {
                    matrix[listId][nextEleId],
                    listId,
                    nextEleId
                });
            }
        }
        return -1;
    }
}