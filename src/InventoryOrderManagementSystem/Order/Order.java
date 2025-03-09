package InventoryOrderManagementSystem.Order;

import InventoryOrderManagementSystem.Invoice.Invoice;
import InventoryOrderManagementSystem.Payment.Payment;
import InventoryOrderManagementSystem.Payment.PaymentMode;
import InventoryOrderManagementSystem.Payment.UPIPaymentMode;
import InventoryOrderManagementSystem.User.User;
import InventoryOrderManagementSystem.Warehouse.Warehouse;
import InventoryOrderManagementSystem.Address.Address;

import java.util.Map;

public class Order {
    private User user;
    private Address deliveryAddress;
    private Map<Integer, Integer> productCategoryAndCountMap;
    private Warehouse warehouse;
    private Invoice invoice;
    private Payment payment;
    private OrderStatus orderStatus;

    public Order(User user, Warehouse warehouse) {
        this.user = user;
        this.productCategoryAndCountMap = user.getUserCart().getCartItems();
        this.warehouse = warehouse;
        this.deliveryAddress = user.getAddress();
        invoice = new Invoice();
        invoice.generateInvoice(this);
    }

    public void checkout() {
        //1. update inventory
        warehouse.removeItemFromInventory(productCategoryAndCountMap);

        //2. make Payment
        boolean isPaymentSuccess = makePayment(new UPIPaymentMode());

        //3. make cart empty
        if (isPaymentSuccess) {
            user.getUserCart().emptyCart();
        } else {
            warehouse.addItemToInventory(productCategoryAndCountMap);
        }
    }

    public boolean makePayment(PaymentMode paymentMode) {
        this.payment = new Payment(paymentMode);
        return payment.makePayment();
    }

    public void generateOrderInvoice() {
        invoice.generateInvoice(this);
    }
}
