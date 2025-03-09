package InventoryOrderManagementSystem;

import InventoryOrderManagementSystem.Address.Address;
import InventoryOrderManagementSystem.Inventory.Inventory;
import InventoryOrderManagementSystem.Order.Order;
import InventoryOrderManagementSystem.Product.Product;
import InventoryOrderManagementSystem.Product.ProductCategory;
import InventoryOrderManagementSystem.User.User;
import InventoryOrderManagementSystem.Warehouse.Warehouse;
import InventoryOrderManagementSystem.Warehouse.WarehouseSelectionStrategy.NearestWarehouseSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class InventoryOrderManagementDriver {
    public static void start() {
        //1. create warehouses in the system
        List<Warehouse> warehouseList = new ArrayList<>();
        warehouseList.add(addWarehouseAndItsInventory());

        //2. create users in the system
        List<User> userList = new ArrayList<>();
        userList.add(createUser());

        //3. feed the system with the initial information
        ProductDeliverySystem productDeliverySystem = new ProductDeliverySystem(userList, warehouseList);
        runDeliveryFlow(productDeliverySystem, 1);
    }

    private static Warehouse addWarehouseAndItsInventory() {
        Warehouse warehouse = new Warehouse();

        Inventory inventory = new Inventory();

        inventory.addCategory(0001, "Pepsi Large Cold Drink", 100);
        inventory.addCategory(0004, "Dove small Soap", 50);

        //CREATE 3 Products

        Product product1 = new Product(1, "Pepsi");
        Product product2 = new Product(2, "Pepsi");
        Product product3 = new Product(3, "Dove");

        inventory.addProduct(product1, 0001);
        inventory.addProduct(product2, 0001);
        inventory.addProduct(product3, 0004);

        warehouse.setInventory(inventory);
        return warehouse;
    }

    private static User createUser() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("KKB");
        user.setAddress(new Address(1, 230011, "city", "state"));
        return user;
    }

    private static void runDeliveryFlow(ProductDeliverySystem productDeliverySystem, int userId) {
        //1. Get the user object
        User user = productDeliverySystem.getUser(userId);

        //2. get warehouse based on user preference
        Warehouse warehouse = productDeliverySystem.getWarehouse(new NearestWarehouseSelectionStrategy());

        //3. get all the inventory to show the user
        Inventory inventory = productDeliverySystem.getInventory(warehouse);

        ProductCategory productCategoryIWantToOrder = null;
        for (ProductCategory productCategory : inventory.getProductCategoryList()) {
            if (productCategory.getCategoryName().equals("Pepsi Large Cold Drink")) {
                productCategoryIWantToOrder = productCategory;
            }
        }

        //4. add product to the cart
        productDeliverySystem.addProductToCart(user, productCategoryIWantToOrder, 2);

        //4. place order
        Order order = productDeliverySystem.placeOrder(user, warehouse);

        //5. checkout
        productDeliverySystem.checkout(order);
    }
}
