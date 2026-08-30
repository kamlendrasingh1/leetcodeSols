class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        long[] endTimesOfRooms = new long[n];
        int[] counts = new int[n];

        for(int i = 0; i < meetings.length; i++){
            int startTime = meetings[i][0];
            int endTime = meetings[i][1];

            int minEndTimeIdx = 0;
            Boolean isRoomAllocated = false;

            for(int room = 0; room < n; room++){
                if(startTime >= endTimesOfRooms[room]){
                    endTimesOfRooms[room] = endTime;
                    counts[room] = counts[room] + 1;
                    isRoomAllocated = true;
                    break;
                }
                if(endTimesOfRooms[room] < endTimesOfRooms[minEndTimeIdx]){
                    minEndTimeIdx = room;
                }
            }
            if(!isRoomAllocated){
                endTimesOfRooms[minEndTimeIdx] = endTimesOfRooms[minEndTimeIdx] + endTime - startTime;
                counts[minEndTimeIdx] = counts[minEndTimeIdx] + 1;
            }
        }
        int maxRoomsCountsIdx = 0;
        for(int i = 0; i < n; i++){
            if(counts[i] > counts[maxRoomsCountsIdx]){
                maxRoomsCountsIdx = i;
            }
        }
        return maxRoomsCountsIdx;
    }
}