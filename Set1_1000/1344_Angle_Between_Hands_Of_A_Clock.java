/*
Hour Hand
In 12 hours Hour hand complete whole circle and cover 360°
So, 1 hour = 360° / 12 = 30°

Since 1 hours = 30°
In 1 minute, hours hand rotate -> 30° / 60 = 0.5°
So total angle because of minutes by hour hand is minutes/60 * 30 or minutes * 0.5

Minute Hand
In 60 minutes Minute Hand completes whole circle and cover 360°.
So, 1 minute -> 360° / 60 = 6°


*/
class Solution {
    public double angleClock(int hour, int minutes) {
        double min = minutes * 6;
        double hr = hour * 30 + (double) minutes * 0.5;
        double angle = Math.abs(hr-min);
        return Math.min(angle, 360-angle);
    }
}
