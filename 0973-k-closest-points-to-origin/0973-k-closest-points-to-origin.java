class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (point1, point2) -> Double.compare(Math.hypot(point1[0], point1[1]), Math.hypot(point2[0], point2[1])));
        return Arrays.copyOfRange(points, 0, k);
    }
}