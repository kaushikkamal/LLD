package ParkingLotSystem.CostComputation;

public class TwoWheelerCostComputation extends CostComputation {

    public TwoWheelerCostComputation(long hour, long minute, long second) {
        super(hour, minute, second);
    }

    @Override
    public double calculateTotalPrice() {
        return 1.2 * super.calculateTotalPrice();
    }
}
