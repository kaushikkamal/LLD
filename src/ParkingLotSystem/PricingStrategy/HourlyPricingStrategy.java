package ParkingLotSystem.PricingStrategy;

public class HourlyPricingStrategy implements PricingStrategy {
    private static final double PRICE = 50.0;

    @Override
    public double getPerUnitPrice() {
        return PRICE;
    }
}
