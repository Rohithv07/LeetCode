/*
My thought process:

Here we have several bulbs and at each moment k, we turn on bulbs. A bulb changes to blue only if its previous  bulbs are turned on. 
So whats the idea here.
If we have say 5 th bulb shine, then 1, 2, 3, 4 will shine too and it will be blue also. So we got a moment where all the bulbs turn blue.
So we start from zero, 
We iterate throught the light array, then we take the max from the lightsOn and elements.
If the lightsOn == i+1, then we have all the bulbs blue..

Eg: lights = [2, 1, 3, 5, 4]   and lightsOn = 0;
lights[0] = 2 -> lightsOn = max(0, 2) = 2 but 2 != 0+1, thus we donot increment moment.
lights[1] = 1 -> lightsOn = max(2, 1) = 2, 2 == 1+1, so we have all blue, increment moment = 1
lights[2] = 3 -> lightsOn = max(2, 3) = 3,  3 == 2+1, so we have all blue, increment moment = 1+1 = 2
lights[3] = 5 -> lightsOn = max(3, 5) = 5, but 5 != 3+1, thus we do not incrememt our moment.
lights[4] = 4 -> lightsOn = max(5, 4) = 5, 5 == 4+1, so we have all blue, incrememnt moment = 2+1 = 3

And finally return the answer.
*/
class Solution {
    public int numTimesAllBlue(int[] light) {
        int moment = 0;
        int lightsOn = 0;
        int length = light.length;
        for (int i=0; i<length; i++) {
            lightsOn = Math.max(lightsOn, light[i]);
            if (lightsOn == i+1)
                moment += 1;
        }
        return moment;
    }
}
