package org.program.Work1;

import java.util.Date;

public class Order {
    private static int IDCounter;
    private int ID;
    private Cart UserCart;
    private Date OrderDate;
    private double TotalPrice;

    public Order(Cart cart) {
        if (cart == null) return;
        ID = IDCounter++;
        UserCart = cart;
        OrderDate = new Date();
        TotalPrice = calculateTotalPrice(cart);
    }

    public int getID() {
        return ID;
    }

    private double calculateTotalPrice(Cart cart) {
        if (cart == null) return Double.NaN;
        double totalPrice = 0.0;
        for (Product product : cart.getProducts()) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void addProduct(Product product) {
        UserCart.addProduct(product);
        TotalPrice += product.getPrice();
    }

    public void removeProduct(Product product) {
        UserCart.removeProduct(product);
        TotalPrice -= product.getPrice();
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public Cart getUserCart() {
        return UserCart;
    }
}
