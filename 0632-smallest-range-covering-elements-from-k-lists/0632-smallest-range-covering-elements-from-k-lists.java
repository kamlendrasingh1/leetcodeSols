class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        int totalElements = 0;
        for (List<Integer> list : nums) {
            totalElements += list.size();
        }
      

        int[][] elements = new int[totalElements][2];
        int numLists = nums.size();

        int index = 0;
        for (int listIdx = 0; listIdx < numLists; listIdx++) {
            for (int value : nums.get(listIdx)) {
                elements[index++] = new int[] {value, listIdx};
            }
        }
      

        Arrays.sort(elements, (a, b) -> a[0] - b[0]);
      
        int left = 0;
        Map<Integer, Integer> listCount = new HashMap<>();
        int[] result = new int[] {-1000000, 1000000};
      
        for (int[] element : elements) {
            int rightValue = element[0];
            int listIndex = element[1];
          

            listCount.merge(listIndex, 1, Integer::sum);
          

            while (listCount.size() == numLists) {
                int leftValue = elements[left][0];
                int leftListIndex = elements[left][1];

                int rangeDiff = rightValue - leftValue - (result[1] - result[0]);
                if (rangeDiff < 0 || (rangeDiff == 0 && leftValue < result[0])) {

                    result[0] = leftValue;
                    result[1] = rightValue;
                }
              

                if (listCount.merge(leftListIndex, -1, Integer::sum) == 0) {
                    listCount.remove(leftListIndex);
                }
                left++;
            }
        }
      
        return result;
    }
}
