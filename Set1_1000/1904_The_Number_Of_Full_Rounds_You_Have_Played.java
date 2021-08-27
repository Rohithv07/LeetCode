class Solution {
    public int numberOfRounds(String startTime, String finishTime) {
        if (startTime == null && finishTime == null)
            return 0;
        int [] start = getTime(startTime);
        int [] end = getTime(finishTime);
        if (end[0] < start[0] || (end[0] == start[0] && end[1] < start[1]))
            end[0] += 24; // overnight
        return (end[0] * 4 + end[1] / 15) - (start[0] * 4 + ((int)Math.ceil((double)start[1] / 15)));
        
    }
    
    public int [] getTime(String s) {
        return new int []{(s.charAt(0) - '0') * 10 + s.charAt(1) - '0', (s.charAt(3) - '0') * 10 + s.charAt(4) - '0'};
    }
}

// 00,15,30,45
