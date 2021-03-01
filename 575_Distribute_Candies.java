class Solution {
    public int distributeCandies(int[] candyType) {
        int length = candyType.length;
        Set<Integer> set = new HashSet<>();
        for (int number : candyType)
            set.add(number);
        int possibleToEat = length / 2;
        if (possibleToEat <= set.size())
            return possibleToEat;
        return set.size();
    }
}

/*
Alice can only eat n / 2 candies and she need to eat different types maximum.

eg : [1, 1, 2, 2, 3, 3]
dictionary
key | value
1      2
2      2
3      2
From each of the available types, ie key is type : We have a total of 2 + 2 + 2 = 6
So total 6 candies are present and we have 3 diff types.
So 3 different types can be eaten.
*/
