package InventoryOrderManagementSystem.User;


import InventoryOrderManagementSystem.Address.Address;
import InventoryOrderManagementSystem.Cart.Cart;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String userName;
    private Address address;
    private Cart userCartDetails;
    private List<Integer> orderIds;

    public User() {
        userCartDetails = new Cart();
        orderIds = new ArrayList<>();
    }

    //get UserCart
    public Cart getUserCart() {
        return userCartDetails;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Cart getUserCartDetails() {
        return userCartDetails;
    }

    public void setUserCartDetails(Cart userCartDetails) {
        this.userCartDetails = userCartDetails;
    }

    public List<Integer> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Integer> orderIds) {
        this.orderIds = orderIds;
    }
}
