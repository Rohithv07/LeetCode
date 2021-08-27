// but this is not efficient and not giving correcr output for larger inputs
class Solution {
    public int numSteps(String s) {
        int power = 0;
        long bin = Integer.parseInt(s, 2);
        return stepsToOne(bin);
    }
    public int stepsToOne(long bin) {
        if (bin == 1)
            return 0;
        int steps = 0;
        while (bin != 1) {
            if (bin % 2 == 0)
                bin = bin / 2;
            else if (bin % 2 != 0)
                bin = bin + 1;
            steps += 1;
        }
        return steps;
    }
}

/*
We haven't encountered any 1. Every char adds one operation.
We encounter our first 1. We set carry to 1 and add two operations.
The rest:
3A. Every 1 needs one operation (carry makes it 0). carry is still 1 due to addition.
3B. Every 0 needs two operations (carry makes it 1). carry is still 1 as we need to add 1 in this case.
Observation: as you can see from 3A and 3B, carry is always 1 after the second phase.
*/
class Solution {
    public int numSteps(String s) {
        int carry = 0;
        int result = 0;
        for (int i=s.length()-1; i>0; i--) {
            result += 1;
            if (s.charAt(i) - '0' + carry == 1) {
                result += 1;
                carry = 1;
            }
        }
        return result + carry;
    }
}
