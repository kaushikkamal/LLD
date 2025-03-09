package InventoryOrderManagementSystem.Order;

import InventoryOrderManagementSystem.User.User;
import InventoryOrderManagementSystem.Warehouse.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {
    private List<Order> orderList;
    private Map<Integer, List<Order>> userIDVsOrders;

    public OrderController() {
        orderList = new ArrayList<>();
        userIDVsOrders = new HashMap<>();
    }

    //create New Order
    public Order createNewOrder(User user, Warehouse warehouse) {
        Order order = new Order(user, warehouse);
        orderList.add(order);

        if (userIDVsOrders.containsKey(user.getUserId())) {
            List<Order> userOrders = userIDVsOrders.get(user.getUserId());
            userOrders.add(order);
            userIDVsOrders.put(user.getUserId(), userOrders);
        } else {
            List<Order> userOrders = new ArrayList<>();
            userOrders.add(order);
            userIDVsOrders.put(user.getUserId(), userOrders);

        }
        return order;
    }


    //remove order
    public void removeOrder(Order order) {

        //remove order capability goes here
    }

    public List<Order> getOrderByCustomerId(int userId) {
        return null;
    }

    public Order getOrderByOrderId(int orderId) {
        return null;
    }
}
