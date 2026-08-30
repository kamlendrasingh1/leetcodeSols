class RoomEndTimeDetails{
    long endTime;
    int idx;

    public RoomEndTimeDetails(long _endTime, int _idx){
        this.endTime = _endTime;
        this.idx = _idx;
    }
}
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        PriorityQueue<RoomEndTimeDetails> occupiedRooms = new PriorityQueue<>(
            (a, b) -> {
                if(a.endTime == b.endTime){
                    return a.idx - b.idx;
                }
                return Long.compare(a.endTime, b.endTime);
            }
        );

        for(int i = 0; i < n; i++){
            availableRooms.add(i);
        }
        int[] counts = new int[n];

        for(int i = 0; i < meetings.length; i++){
            int startTime = meetings[i][0];
            int endTime = meetings[i][1];

            int minEndTimeIdx = 0;
            Boolean isRoomAllocated = false;

            while(!occupiedRooms.isEmpty()){
                if(startTime >= occupiedRooms.peek().endTime){
                    RoomEndTimeDetails rETD = occupiedRooms.poll();
                    availableRooms.add(rETD.idx);
                }else{
                    break;
                }
            }

            if(availableRooms.isEmpty()){
                RoomEndTimeDetails minEndTimeOccupiedDetails = occupiedRooms.poll();
                minEndTimeOccupiedDetails.endTime = minEndTimeOccupiedDetails.endTime + (endTime - startTime);
                occupiedRooms.add(new RoomEndTimeDetails(minEndTimeOccupiedDetails.endTime, minEndTimeOccupiedDetails.idx));
                counts[minEndTimeOccupiedDetails.idx] = counts[minEndTimeOccupiedDetails.idx] + 1;
                }else{
                int room = availableRooms.poll();
                counts[room] = counts[room] + 1;
                occupiedRooms.add(new RoomEndTimeDetails(endTime, room));
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