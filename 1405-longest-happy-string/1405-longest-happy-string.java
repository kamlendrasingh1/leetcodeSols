import java.util.PriorityQueue;

class CharacterCount {
    int count;
    char c;

    public CharacterCount(int count, char c) {
        this.count = count;
        this.c = c;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<CharacterCount> maxHeap =
                new PriorityQueue<>((x, y) -> y.count - x.count);

        if (a > 0) {
            maxHeap.offer(new CharacterCount(a, 'a'));
        }
        if (b > 0) {
            maxHeap.offer(new CharacterCount(b, 'b'));
        }
        if (c > 0) {
            maxHeap.offer(new CharacterCount(c, 'c'));
        }

        StringBuilder res = new StringBuilder();

        while (!maxHeap.isEmpty()) {

            CharacterCount first = maxHeap.poll();

            // If adding first character would create 3 consecutive chars
            if (res.length() >= 2
                    && res.charAt(res.length() - 1) == first.c
                    && res.charAt(res.length() - 2) == first.c) {

                if (maxHeap.isEmpty()) {
                    break;
                }

                CharacterCount second = maxHeap.poll();

                res.append(second.c);
                second.count--;

                if (second.count > 0) {
                    maxHeap.offer(second);
                }

                // Put first character back for future use
                maxHeap.offer(first);

            } else {

                res.append(first.c);
                first.count--;

                if (first.count > 0) {
                    maxHeap.offer(first);
                }
            }
        }

        return res.toString();
    }
}