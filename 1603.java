class ParkingSystem {

    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        // Map carType 1, 2, 3 to indices 1, 2, 3 by allocating an array of size 4
        slots = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType) {
        if (slots[carType] > 0) {
            slots[carType]--;
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
