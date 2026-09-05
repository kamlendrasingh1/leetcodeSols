class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for(int i = 0; i < k; i = i + 1){
            int num = nums[i];
            if(maxHeap.size() == 0){
                maxHeap.add(num);
                continue;
            }
            if(maxHeap.size() == minHeap.size()){
                if(num > maxHeap.peek()){
                    minHeap.add(num);
                    maxHeap.add(minHeap.poll());
                } else{
                    maxHeap.add(num);
                }
            } else{
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        }
        int n = nums.length;
        double[] res = new double[n - k + 1];
        int j = 0;

        Map<Integer, Integer> map = new HashMap<>();
        res[j] = k % 2 == 1 ? maxHeap.peek() : ((double) maxHeap.peek() + minHeap.peek()) / 2;

        for(int i = k; i < n; i++){
            int numA = nums[i];
            int numR = nums[i - k];

            map.put(numR, map.getOrDefault(numR, 0) + 1);

            int counter = 0;

            if(numA <= maxHeap.peek()){
                maxHeap.add(numA);
                counter = counter + 1;
            } else{
                minHeap.add(numA);
                counter = counter - 1;
            }
            if(numR <= maxHeap.peek()){
                counter = counter - 1;
            } else{
                counter = counter + 1;
            }
            if(counter > 0){
                minHeap.add(maxHeap.poll());
            }
            if(counter < 0){
                maxHeap.add(minHeap.poll());
            }

            while(!maxHeap.isEmpty() && map.getOrDefault(maxHeap.peek(), 0) > 0){
                int ele = maxHeap.peek();
                maxHeap.poll();
                map.put(ele, map.get(ele) - 1);
            }
            while(!minHeap.isEmpty() && map.getOrDefault(minHeap.peek(), 0) > 0){
                int ele = minHeap.peek();
                minHeap.poll();
                map.put(ele, map.get(ele) - 1);
            }
            j = j + 1;

            res[j] = k % 2 == 1 ? maxHeap.peek() : ((double) maxHeap.peek() + minHeap.peek()) / 2;
        }
        return res;
    }
}