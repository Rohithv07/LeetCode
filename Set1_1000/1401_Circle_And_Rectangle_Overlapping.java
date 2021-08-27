/*
-> (y <= y2 && y >= y1): the two horizontal lines are at different sides of the circle center

-> Math.min(Math.abs(y1 - y), Math.abs(y2 - y)): the distance between the horizontal line and the circle center. (There are two such distances. Take the smaller one.)

-> (x >= x1 && x <= x2): the two vertical lines are at different sides of the circle center

-> Math.min(Math.abs(x1 - x), Math.abs(x2 - x)): the distance between the vertical line and the circle center. (There are two such distances. Take the smaller one.)

->The 0 after ?: if the two lines are at different sides, at the return line we will check only the other value (i.e. the value calculated from the other two lines)

-> xx * xx + yy * yy <= radius * radius:

(a) if xx == 0 and yy==0, that means circle center is in the rectangle
(b) if only one of xx and yy is zero, that means we want to check the distance between circle center and the line that is closest to the circle center.
(c) if both xx and yy are not zero, that means we want to check the distance between circle center and the rectangle corner that is closest to the circle center.

*/
class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int y = (y2 >= y_center && y1 <= y_center) ? 0 : Math.min(Math.abs(y2 - y_center), Math.abs(y1-y_center));
        int x = (x2 >= x_center && x1 <= x_center) ? 0 : Math.min(Math.abs(x2 - x_center), Math.abs(x1 - x_center));
        if (x * x + y*y <= radius * radius)
            return true;
        return false;
    }
}
