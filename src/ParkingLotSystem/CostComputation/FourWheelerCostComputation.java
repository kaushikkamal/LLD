package ParkingLotSystem.CostComputation;

public class FourWheelerCostComputation extends CostComputation {
    public FourWheelerCostComputation(long hour, long minute, long second) {
        super(hour, minute, second);
    }

    @Override
    public double calculateTotalPrice() {
        return 1.8 * super.calculateTotalPrice();
    }
}
