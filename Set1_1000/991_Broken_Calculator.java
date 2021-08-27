// 1st check if X > Y, then we need to decrease by 1 and the answer will be X - Y
// Otherwise we have two options
// Until Y > X -> if Y is even, update Y as Y / 2 else Y + 1;
// increment a counter
// final result will be counter + X - Y
// O(logY)


class Solution {
    public int brokenCalc(int X, int Y) {
        if (X > Y) {
            return X - Y;
        }
        int result = 0;
        while (Y > X) {
            Y = Y % 2 == 0 ? Y / 2 : Y + 1;
            result += 1;
        }
        return result + X - Y;
    }
}
