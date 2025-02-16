package VendingMachineSystem.Inventory.Item;

public class Item {
    private int price;
    private ItemType itemType;

    public Item() {
    }

    public Item(int price, ItemType itemType) {
        this.price = price;
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", itemType=" + itemType +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
