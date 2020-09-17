class Solution {
    /*
    My thought process:
    So in question its given we are initially at 0, 0 at North directions. So we need to keep track of the points as well as the directions in which the robot travels. So we can have x, y = 0 and directions = North
    
    Now our problem is to find whether the robot is moving outside the circle after following some instructions. So the robot leaves the circle if it keep moving in the North direction.
    
    So lets loop through each and every character from the instruction string, then:
    1. We check whether its G, if G then we have to move one point from the current position.
        SO if we are at North direction, then if we consider the coordinate, we are at +y directions, so we will move only up, just understand like that, SO we increment our y by 1, by following this pattern we can automatically deduce that if we are at South, then decrement y by 1. Same way for East, increment x by 1 and for West decrement x by 1.
    2. Next we check wheter its L, then we have to move 90 degree left wards.
                    North
            West                East    , So do a counter clockwise assumption. If we are at a directions North, then its 
                                          counter clockwis, yes West update direction by west, Same way if our directions is                          South                West, them its counter clockwise south, same way for direction south, update                                                     direction by east. So just rememebr if chaarcter is L, then counter clockwise.
    3. Next whetehr the character if R, then we already got it rememebr about clockwise direction and update direction according to it
    
    Finally we check whetehr the robot get back to the position, if yes, return true as the robot donot go out of the circle.
    We check whether the direction is still North, then it will sure go out of the circle, so return false.
    If none of the above condition satisfies, then also the robot will be some where inside the circle, so return true.
    */
    public boolean isRobotBounded(String instructions) {
        if (instructions.length() == 0)
            return false;
        int x = 0;
        int y = 0;  // initial points of the robot
        String directions = "North"; // initial direction of robot
        /*
                    North
            West                East
                    South
                    
        */
        for (char ch: instructions.toCharArray()) {
            if (ch == 'G') {
                if (directions.equals("North"))
                    y += 1;
                else if (directions.equals("South"))
                    y -= 1;
                else if(directions.equals("East"))
                    x += 1;
                else
                    x -= 1;
            }
            else if (ch == 'L') {
                if (directions.equals("North"))
                    directions = "West";
                else if (directions.equals("West"))
                    directions = "South";
                else if (directions.equals("South"))
                    directions = "East";
                else directions = "North";
            }
            else if (ch == 'R') {
                if (directions.equals("North"))
                    directions = "East";
                else if (directions.equals("East"))
                    directions = "South";
                else if (directions.equals("South"))
                    directions = "West";
                else directions = "North";
            }
        }
        if (x == 0 && y == 0)
            return true;
        if (directions.equals("North"))
            return false;
        return true;
    }
}
