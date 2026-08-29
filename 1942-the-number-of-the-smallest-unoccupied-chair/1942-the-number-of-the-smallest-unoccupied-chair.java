import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        /*
         * Store:
         * events[i][0] = arrival time
         * events[i][1] = leaving time
         * events[i][2] = original friend index
         *
         * Keeping the original index lets us identify targetFriend
         * even after sorting.
         */
        int[][] events = new int[n][3];

        for (int i = 0; i < n; i++) {
            events[i][0] = times[i][0];
            events[i][1] = times[i][1];
            events[i][2] = i;
        }

        // Sort friends by arrival time.
        Arrays.sort(events, (a, b) ->
                Integer.compare(a[0], b[0])
        );

        /*
         * Contains all currently available chair numbers.
         * Because it is a min-heap, poll() returns the smallest chair.
         */
        PriorityQueue<Integer> availableChairs =
                new PriorityQueue<>();

        for (int chair = 0; chair < n; chair++) {
            availableChairs.offer(chair);
        }

        /*
         * Each entry is:
         * occupiedChairs element = {leavingTime, chairNumber}
         *
         * The chair with the earliest leaving time stays at the top.
         */
        PriorityQueue<int[]> occupiedChairs =
                new PriorityQueue<>((a, b) -> {
                    if (a[0] == b[0]) {
                        return Integer.compare(a[1], b[1]);
                    }

                    return Integer.compare(a[0], b[0]);
                });

        for (int[] event : events) {
            int arrivalTime = event[0];
            int leavingTime = event[1];
            int friendIndex = event[2];

            /*
             * Free every chair whose friend has already left.
             *
             * <= is important because if one friend leaves at time 4
             * and another arrives at time 4, the chair is available.
             */
            while (!occupiedChairs.isEmpty()
                    && occupiedChairs.peek()[0] <= arrivalTime) {

                int[] freeChairInfo = occupiedChairs.poll();
                int freeChair = freeChairInfo[1];

                availableChairs.offer(freeChair);
            }

            // Get the smallest currently available chair.
            int assignedChair = availableChairs.poll();

            // Return immediately when the target friend arrives.
            if (friendIndex == targetFriend) {
                return assignedChair;
            }

            // Mark this chair as occupied until leavingTime.
            occupiedChairs.offer(
                    new int[]{leavingTime, assignedChair}
            );
        }

        return -1;
    }
}