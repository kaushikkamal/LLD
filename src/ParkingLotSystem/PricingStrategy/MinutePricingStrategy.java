package ParkingLotSystem.PricingStrategy;

public class MinutePricingStrategy implements PricingStrategy {
    private static final double PRICE = .5;

    @Override
    public double getPerUnitPrice() {
        return PRICE;
    }
}
