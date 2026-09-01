class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int [] frequency = new int [26];
        for (char ch : tasks) {
            frequency[ch - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
        Queue<int[]> queue = new LinkedList<>();
        int cpuInterval = 0;
        for (int index = 0; index < 26; index++) {
            if (frequency[index] != 0)
                maxHeap.offer(frequency[index]);
        }
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            cpuInterval++;
            if (!maxHeap.isEmpty()) {
                int mostFrequent = maxHeap.poll();
                mostFrequent--;
                int idleTime = cpuInterval + n;
                if (mostFrequent > 0)
                    queue.offer(new int []{mostFrequent, idleTime});
            }
            if (!queue.isEmpty() && queue.peek()[1] == cpuInterval) {
                maxHeap.offer(queue.poll()[0]);
            }
        }
        return cpuInterval;
    }
}

class MaxHeapComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2) {
        return Integer.compare(num2, num1);
    }
}