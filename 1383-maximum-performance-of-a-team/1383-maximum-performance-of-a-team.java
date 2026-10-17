class Solution {
    private static final int MOD = 1_000_000_007;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for(int i = 0; i < n; i++){
            engineers[i] = new int[]{speed[i], efficiency[i]};
        }

        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long speedM = 0;
        long performance = 0;

        for(var eng : engineers){
            int a = eng[0];
            int b = eng[1];

            minHeap.offer(a);
            speedM += a;

            if(minHeap.size() > k){
                speedM -= minHeap.poll();
            }
            performance = Math.max(performance, speedM * b);
        }
        return (int) (performance % MOD);
    }
}