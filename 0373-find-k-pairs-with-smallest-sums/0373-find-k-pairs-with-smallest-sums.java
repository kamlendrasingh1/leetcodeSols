class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(element -> element[0]));

        for(int i = 0; i < Math.min(nums1.length, k); i++){
            minHeap.offer(new int[] {
                nums1[i] + nums2[0],
                i,
                0
            });
        }
        List<List<Integer>> result = new ArrayList<>();
        while(!minHeap.isEmpty() && k > 0){
            int[] currentElement = minHeap.poll();
            int nums1Index = currentElement[1];
            int nums2Index = currentElement[2];

            result.add(Arrays.asList(nums1[nums1Index], nums2[nums2Index]));
            k--;
            if(nums2Index + 1 < nums2.length){
                minHeap.offer(new int[] {
                    nums1[nums1Index] + nums2[nums2Index + 1],
                    nums1Index,
                    nums2Index + 1
                });
            }
        }
        return result;
    }
}