package InventoryOrderManagementSystem.Invoice;

import InventoryOrderManagementSystem.Order.Order;

public class Invoice {
    private int totalItemPrice;
    private int totalTax;
    private int totalFinalPrice;

    //generate Invoice
    public void generateInvoice(Order order) {
        //it will compute and update the above details
        totalItemPrice = 200;
        totalTax = 20;
        totalFinalPrice = 220;
    }

}
