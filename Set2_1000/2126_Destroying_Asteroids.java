class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        if (asteroids.length == 1) {
            return mass >= asteroids[0];
        }
        Arrays.sort(asteroids);
        long convertedMass = mass;
        for (int asteroid : asteroids) {
            if (convertedMass < asteroid) {
                return false;
            }
            convertedMass += asteroid;
        }
        return true;
    }
}