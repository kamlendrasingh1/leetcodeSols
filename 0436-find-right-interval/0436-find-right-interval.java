class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[] res = new int[len];

        for(int i = 0; i < len; i++){
            int minStartIdx = -1;

            for(int j = 0; j < len; j++){
                if(intervals[j][0] >= intervals[i][1]){
                    if(minStartIdx == -1){
                        minStartIdx = j;
                    }
                    if(intervals[j][0] < intervals[minStartIdx][0]){
                        minStartIdx = j;
                    }
                }
            }
            res[i] = minStartIdx;
        }
        return res;
    }
}