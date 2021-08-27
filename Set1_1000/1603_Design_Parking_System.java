class ParkingSystem {
    private List<Integer> s;
    private List<Integer> m;
    private List<Integer> b;
    private int big;
    private int small;
    private int medium;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
        s = new ArrayList<>();
        m = new ArrayList<>();
        b = new ArrayList<>();;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1 && b.size() < big) {
            b.add(1);
            return true;
        }
        if (carType == 2 && m.size() < medium) {
            m.add(1);
            return true;
        }
        if (carType == 3 && s.size() < small) {
            s.add(1);
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */


Solution 2:
class ParkingSystem {
    int [] count;
    public ParkingSystem(int big, int medium, int small) {
        count = new int[] {big, medium, small};
    }
    
    public boolean addCar(int carType) {
        return count[carType-1] -- > 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
