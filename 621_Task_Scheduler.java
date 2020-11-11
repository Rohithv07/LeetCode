class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        if (tasks.length == 0)
            return 0;
        // lets create an int array to store the frequency
        int [] freq = new int [26];
        for (char ch: tasks) 
            freq[ch-'A'] += 1;
        // now sort the array to get the most frequenct charcater at the last
        Arrays.sort(freq); // 26 * log(26) => Considered as O(1)
        int maxValue = freq[25] - 1;  // we do -1 as we dont want idle state if we are at the very end;
        int availableIdleSlot = maxValue * n;  // this many idle slot will be avaiable
        for (int i=24; i>=0; i--) {
            // now update the available slot
            availableIdleSlot -= Math.min(freq[i], maxValue);
        }
        return availableIdleSlot > 0 ? availableIdleSlot + tasks.length : tasks.length; 
    }
}

/*
tasks = ["A","A","A","B","B","B"], n = 2
freq after sorting = [3, 3, 0, .....] 
    maxValue = 3 - 1 = 2
    idleslot = 2 * 2 = 4
        
            idleslot -= min(3, 2)
            4 -= 2
            = 2
idleslot > 0 therefore final asnwer = idleslotremaining + taskslength
= 2 + 6 = 8

*/
