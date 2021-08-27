class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int [] dynamicArray = new int[366];
        dynamicArray[0] = 0;
        int day = 0;
        for (int i=1; i<=365; i++) {
            if (day == days.length)
                break;
            if (days[day] != i)
                dynamicArray[i] = dynamicArray[i-1];
            else {
                int one = costs[0] + dynamicArray[i-1];
                int seven = costs[1] + dynamicArray[Math.max(0, i-7)];
                int thirty = costs[2] + dynamicArray[Math.max(0, i-30)];
                dynamicArray[i] = Math.min(one, Math.min(seven, thirty));
                day += 1;
            }
        }
        return dynamicArray[days[days.length-1]];
    }
}
