/* My thought Process
So here we have to go consider the numbers from low to high, compute the power according to the condition and calculate the step to reach 1, and we have to sort the number based on the power of the number and return the kth value.

So the approach I used is to use a list of a particular type, say Power. So we need a class with varibales power, number and a public constructor initialise with power and number.

So at eaach time we compute the power, a new type of Power with the number and power is stored on to the list.
Now we do the sort based on the powers and we finally return the kth number.
Note , since we are having a list of type Power, inorder to get the kth number, we also need to add .number along wiht the return statmenet.
Thats the problem.

*/


class Solution {
    public int getKth(int low, int high, int k) {
        List<Power> list = new ArrayList<>();
        while (low <= high) {
            int value = low;
            int power = 0;
            while (value != 1) {
                if (value % 2 == 0)
                    value /= 2;
                else
                    value = value * 3 + 1;
                power += 1;
            }
            list.add(new Power(low, power));
            low += 1;
        }
        Collections.sort(list, (a, b) -> a.power - b.power);
        return list.get(k-1).number;
    }
}
class Power {
    int number;
    int power;
    public Power(int number, int power) {
        this.number = number;
        this.power = power;
    }
}
