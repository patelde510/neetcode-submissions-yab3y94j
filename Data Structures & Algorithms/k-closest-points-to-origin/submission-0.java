class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));        
        int[][] output = new int[k][2];

        for (int[] point : points) {
            int distance = getDistance(point);
            // System.out.println(distance);
            minHeap.offer(new int[]{distance, point[0], point[1]});
        }

        int i = 0;
        while (k > 0) {
            int[] point = minHeap.poll();
            output[i] = new int[]{point[1], point[2]};
            k--;
            i++;
        }

        return output;
    }

    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
