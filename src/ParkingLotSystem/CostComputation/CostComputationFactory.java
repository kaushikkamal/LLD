package ParkingLotSystem.CostComputation;

import ParkingLotSystem.Vehicle.VehicleType;

public class CostComputationFactory {

    public CostComputationFactory() {
    }

    public static CostComputation getCostComputation(VehicleType vehicleType, long hour, long minute, long second) {
        CostComputation computation;
        switch (vehicleType) {
            case TWO_WHEELER: {
                computation = new TwoWheelerCostComputation(hour, minute, second);
                break;
            }
            case FOUR_WHEELER: {
                computation = new FourWheelerCostComputation(hour, minute, second);
                break;
            }
            default: {
                computation = null;
            }
        }

        return computation;
    }
}
