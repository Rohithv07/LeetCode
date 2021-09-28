class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        
        // When we use double as a key in hashmap, we might have problem on precision. Since, floating point numbers have a limited precision. So, mighy give wrong answer on some cases even when two ratios are equal.
        // using double
        
        if (rectangles == null || rectangles.length == 0) {
            return 0;
        }
        // here we are storing the ratio as key and its occurance as values
        // counter will be updated by looking upon the values
        Map<Double, Long> ratioFrequency = new HashMap<>();
        long counter = 0;
        for (int [] rectangle : rectangles) {
            Double fraction = Double.valueOf(rectangle[0]) / Double.valueOf(rectangle[1]);
            counter += ratioFrequency.getOrDefault(fraction, 0l);
            ratioFrequency.put(fraction, ratioFrequency.getOrDefault(fraction, 0l) + 1);
        }
        return counter;
        
        // without using Double rather dividing the width and height by its greatest common divisor 
        
        if (rectangles == null || rectangles.length == 0) {
            return 0;
        }
        long counter = 0;
        Map<String, Long> widthHeightRatio = new HashMap<>();
        for (int [] rectangle : rectangles) {
            int width = rectangle[0];
            int height = rectangle[1];
            int gcd = findGCD(width, height);
            width /= gcd;
            height /= gcd;
            StringBuilder sb = new StringBuilder();
            sb.append(width).append("+").append(height);
            String key = sb.toString();
            counter += widthHeightRatio.getOrDefault(key, 0l);
            widthHeightRatio.put(key, widthHeightRatio.getOrDefault(key, 0l) + 1);
        }
        return counter;
    }
    
    public int findGCD(int width, int height) {
        if (height == 0) {
            return width;
        }
        return findGCD(height, width % height);
    }
}