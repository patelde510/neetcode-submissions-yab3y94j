class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));        
        int[][] output = new int[k][2];

        for (int[] point : points) {
            double distance = getDistance(point);
            // System.out.println(distance);
            minHeap.offer(new double[]{distance, point[0], point[1]});
        }

        int i = 0;
        while (k > 0) {
            double[] point = minHeap.poll();
            output[i] = new int[]{(int) point[1], (int) point[2]};
            k--;
            i++;
        }

        return output;
    }

    private double getDistance(int[] point) {
        return Math.sqrt(Math.pow((point[0] - 0), 2) + Math.pow((point[1] - 0), 2));
    }
}
