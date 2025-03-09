package InventoryOrderManagementSystem;

import InventoryOrderManagementSystem.Cart.Cart;
import InventoryOrderManagementSystem.Inventory.Inventory;
import InventoryOrderManagementSystem.Order.Order;
import InventoryOrderManagementSystem.Order.OrderController;
import InventoryOrderManagementSystem.Product.ProductCategory;
import InventoryOrderManagementSystem.User.User;
import InventoryOrderManagementSystem.User.UserController;
import InventoryOrderManagementSystem.Warehouse.Warehouse;
import InventoryOrderManagementSystem.Warehouse.WarehouseController;
import InventoryOrderManagementSystem.Warehouse.WarehouseSelectionStrategy.WarehouseSelectionStrategy;

import java.util.List;

public class ProductDeliverySystem {
    private UserController userController;
    private WarehouseController warehouseController;
    private OrderController orderController;

    public ProductDeliverySystem(List<User> userList, List<Warehouse> warehouseList) {
        userController = new UserController(userList);
        warehouseController = new WarehouseController(warehouseList, null);
        orderController = new OrderController();
    }

    //get user object
    public User getUser(int userId) {
        return userController.getUser(userId);
    }

    //get warehouse
    public Warehouse getWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy) {
        return warehouseController.selectWarehouse(warehouseSelectionStrategy);
    }

    //get inventory
    public Inventory getInventory(Warehouse warehouse) {
        return warehouse.getInventory();
    }

    //add product to cart
    public void addProductToCart(User user, ProductCategory product, int count) {
        Cart cart = user.getUserCart();
        cart.addItemInCart(product.getProductCategoryId(), count);
    }

    //place order
    public Order placeOrder(User user, Warehouse warehouse) {
        return orderController.createNewOrder(user, warehouse);
    }

    public void checkout(Order order) {
        order.checkout();
    }
}
