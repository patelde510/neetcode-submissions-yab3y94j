class Solution {
    private PriorityQueue<Integer> pq;
    public int lastStoneWeight(int[] stones) {
        pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : stones) {
            pq.offer(num);
        }

        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if (stone1 < stone2) {
                pq.offer(stone2 - stone1);
            } else if (stone2 < stone1) {
                pq.offer(stone1 - stone2);
            } else {
                pq.offer(0);
            }
        }

        return pq.poll();
    }
}
