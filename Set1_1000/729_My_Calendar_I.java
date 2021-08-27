class MyCalendar {

    private List<int []> booking;
    public MyCalendar() {
        booking = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int [] books : booking) {
            if (Math.max(books[0], start) < Math.min(books[1], end))
                return false;
        }
        booking.add(new int [] {start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
