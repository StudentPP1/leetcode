package org.example.eazy.designParkingSystem;

import java.util.HashMap;

class ParkingSystem {
    private final HashMap<Integer, Integer> parking = new HashMap<>();
    public ParkingSystem(int big, int medium, int small) {
        parking.put(1, big);
        parking.put(2, medium);
        parking.put(3, small);
    }

    // ! 1 -> big, 2 -> medium, 3 -> small
    public boolean addCar(int carType) {
        Integer freeSlots = parking.get(carType);
        if (freeSlots != 0) {
            freeSlots -= 1;
            parking.put(carType, freeSlots);
            return true;
        }
        return false;
    }
}
