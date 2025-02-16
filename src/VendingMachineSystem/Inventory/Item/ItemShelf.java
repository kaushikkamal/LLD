package VendingMachineSystem.Inventory.Item;

public class ItemShelf {
    private int code;
    private Item item;
    private int availableQuantity;

    public ItemShelf() {
    }

    @Override
    public String toString() {
        return "ItemShelf{" + "code=" + code + ", item=" + item + ", availableQuantity=" + availableQuantity + '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
