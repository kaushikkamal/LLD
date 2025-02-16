package VendingMachineSystem;

public enum Cash {
    ONE(1), FIVE(5), TEN(10), FIFTY(50), HUNDRED(100), FIVE_HUNDRED(500);
    private final int value;

    Cash(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
