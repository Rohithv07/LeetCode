/*
O(logn) add operation 
O(1) is find median operation
*/

class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean isEven = true;
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }
    
    public void addNum(int num) {
        if (isEven) {
            large.offer(num);
            small.offer(large.poll());
        }
        else {
            small.offer(num);
            large.offer(small.poll());
        }
        isEven = !isEven;
    }
    
    public double findMedian() {
        if (isEven) {
            return (small.peek() + large.peek()) / 2.0;
        }
        else {
            return small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */