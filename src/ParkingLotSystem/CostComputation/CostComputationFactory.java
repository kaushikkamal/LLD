package ParkingLotSystem.CostComputation;

import ParkingLotSystem.Vehicle.VehicleType;

public class CostComputationFactory {

    public CostComputationFactory() {
    }

    public static CostComputationInterface getCostComputation(VehicleType vehicleType, long hour, long minute, long second) {
        CostComputationInterface computation;
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
