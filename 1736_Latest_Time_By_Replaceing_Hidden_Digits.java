class Solution {
    public String maximumTime(String time) {        
        char[] times = time.toCharArray();
        if(times[0] == '?') {
            times[0] = times[1] <= '3' || times[1] == '?' ? '2' : '1';
        }
        
        if(times[1] == '?') {
            times[1] = times[0] == '2' ? '3' : '9';
        }
        
        if(times[3] == '?') {
            times[3] = '5';
        }
        
        if(times[4] == '?') {
            times[4] = '9';
        }
        
        return new String(times);
    }
}
