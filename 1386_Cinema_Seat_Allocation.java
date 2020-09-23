/* 
My thought process :

So initially I tried to create a 2d array to store the filled seats and to have a knowledge about which are the seats available for later check. So I traversed through the reservedseat and I filled the cells and left the cells that are not reserved as 0. But some how, it doesnt worked and my array was not filled with values what I was expected.
So I finally looks into the discuss section and I use a solution using HashMap.

So in this, we store each of the row as key and its corresponding reservation as values in the form of a list. So we update the map according to which of the seats are reserved. 

So now we will be having a map with key as the row of seats and values as a list with which of the seats are reserved.


Now our requirement is Return the maximum number of four-person groups you can assign on the cinema seats. A four-person group occupies four adjacent seats in one single row. Seats across an aisle (such as [3,3] and [3,4]) are not considered to be adjacent, but there is an exceptional case on which an aisle split a four-person group, in that case, the aisle split a four-person group in the middle, which means to have two people on each side.



so -> 1 2 3     4 5 6 7     8 9 10

So what are the possibilities here: here the seat will be 2 3 4 5 or 6 7 8 9 or 4 5 6 7.............

So we can just check in the list whether we have empty seats of above formation, if it exists, then we increase our counter.

And this will be our final answer.
*/


class Solution {
	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		int count = 0;
		Map<Integer, List<Integer>> rowReserved = new HashMap<>();
		for (int [] row: reservedSeats) {
			if (rowReserved.containsKey(row[0]))
				rowReserved.get(row[0]).add(row[1]);
			else
				rowReserved.put(row[0], new ArrayList<>(Arrays.asList(row[1])));
		}
		count = (n - rowReserved.size()) * 2; //  here no reservation
		for (List<Integer> list: rowReserved.values()) {
			boolean filled = false;
			if (!list.contains(2) && !list.contains(3) && !list.contains(4) && !list.contains(5)) {
				filled = true;
				count += 1;
			}
			if (!list.contains(6) && !list.contains(7) && !list.contains(8) && !list.contains(9)) {
				filled = true;
				count += 1;
			}
			if (!filled) {
				if (!list.contains(4) && !list.contains(5) && !list.contains(6) && !list.contains(7)) {
					count += 1;
				}
			}
		}
		return count;
    }
}
