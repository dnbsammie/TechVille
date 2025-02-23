package controller;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cartItems = new ArrayList<>();

    public void addToCart(Product product) {
        cartItems.add(product);
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public double calculateTotal() {
        double total = cartItems.stream().mapToDouble(Product::getPrice).sum();
        return applyDiscount(total, cartItems.size());
    }

    private double applyDiscount(double total, int itemCount) {
        int discountLevel = Math.min(itemCount / 5, 8);
        double discount = discountLevel * 5.0;
        return total * (1 - discount / 100);
    }    

    public void clearCart() {
        cartItems.clear();
    }    
}
