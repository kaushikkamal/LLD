package ParkingLotSystem.PricingStrategy;

public class SecondPricingStrategy implements PricingStrategy {
    private static final double PRICE = .2;

    @Override
    public double getPerUnitPrice() {
        return PRICE;
    }
}
