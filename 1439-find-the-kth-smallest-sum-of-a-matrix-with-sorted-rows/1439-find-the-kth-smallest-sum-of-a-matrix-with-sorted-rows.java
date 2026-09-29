class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int[] row = mat[0];
        for (int i = 1; i < mat.length; i++) {
            row = kSmallestPairSums(row, mat[i], k);
        }
        return row[k - 1];
    }

    private int[] kSmallestPairSums(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], 0});
        }

        int[] res = new int[Math.min(k, nums1.length * nums2.length)];
        int idx = 0;

        while (idx < res.length && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int sum = curr[0];
            int j = curr[1];
            res[idx++] = sum;

            if (j + 1 < nums2.length) {
                int nextVal = sum - nums2[j] + nums2[j + 1];
                minHeap.offer(new int[]{nextVal, j + 1});
            }
        }
        return res;
    }
}