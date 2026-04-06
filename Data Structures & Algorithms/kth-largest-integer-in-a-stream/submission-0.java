class KthLargest {

    private PriorityQueue<Integer> numbers;
    private int kth;

    public KthLargest(int k, int[] nums) {
        this.kth = k;
        this.numbers = new PriorityQueue<>();
        for (int num : nums) {
            numbers.add(num);
            if (numbers.size() > k) numbers.poll();
        }
    }
    
    public int add(int val) {
        numbers.add(val);
        if (numbers.size() > kth) {
            numbers.poll();
        }
        return numbers.peek();
    }
}
