class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) {
            return nums;
        }
        int n = nums.length;
        int maxNum = Arrays.stream(nums).max().getAsInt();
        int[] ans = new int[n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] a) -> a[1]));

        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[] { nums[i], i });
        }

        while (k > 0 && (long) minHeap.peek()[0] * multiplier <= maxNum) {
            int num = minHeap.peek()[0];
            int i = minHeap.poll()[1];
            minHeap.offer(new int[] { num * multiplier, i });
            --k;
        }

        List<int[]> sortedIndexedNums = new ArrayList<>(minHeap);

        Collections.sort(sortedIndexedNums,
                Comparator.comparingInt((int[] sortedIndexedNum) -> sortedIndexedNum[0])
                        .thenComparingInt((int[] sortedIndexedNum) -> sortedIndexedNum[1]));

        int multipliersPerNum = k / n;
        int remainingK = k % n;

        for (int[] indexedNums : sortedIndexedNums) {
            indexedNums[0] = (int) ((long) indexedNums[0] * modPow(multiplier, multipliersPerNum) % MOD);
        }

        for (int i = 0; i < remainingK; ++i) {
            sortedIndexedNums.get(i)[0] = (int) ((long) sortedIndexedNums.get(i)[0] * multiplier % MOD);
        }

        for (int[] indexedNums : sortedIndexedNums) {
            int num = indexedNums[0];
            int i = indexedNums[1];
            ans[i] = num;
        }
        return ans;
    }

    private static int MOD = 1_000_000_007;

    private long modPow(long x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return x * modPow(x, n - 1) % MOD;
        }
        return modPow(x * x % MOD, n / 2);
    }
}