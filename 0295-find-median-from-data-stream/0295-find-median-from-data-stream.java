class MedianFinder {
    private PriorityQueue<Integer> left; //max heap
    private PriorityQueue<Integer> right; //min heap

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        } else if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() != right.size()) 
            return (double) left.peek();
        return (left.peek() + right.peek()) / 2.0;
    }
}