package ParkingLotSystem.CostComputation;

import ParkingLotSystem.PricingStrategy.HourlyPricingStrategy;
import ParkingLotSystem.PricingStrategy.MinutePricingStrategy;
import ParkingLotSystem.PricingStrategy.PricingStrategy;
import ParkingLotSystem.PricingStrategy.SecondPricingStrategy;

public class CostComputation implements CostComputationInterface {
    private PricingStrategy hourStrategy;
    private PricingStrategy minuteStrategy;
    private PricingStrategy secondStrategy;

    private long hour;
    private long minute;
    private long second;

    public CostComputation() {
    }

    public CostComputation(long hour, long minute, long second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        hourStrategy = new HourlyPricingStrategy();
        minuteStrategy = new MinutePricingStrategy();
        secondStrategy = new SecondPricingStrategy();
    }

    public double calculateTotalPrice() {
        return (hour * hourStrategy.getPerUnitPrice())
                + (minute * minuteStrategy.getPerUnitPrice())
                + (second * secondStrategy.getPerUnitPrice());
    }
}
