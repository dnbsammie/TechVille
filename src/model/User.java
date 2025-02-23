package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private List<List<Product>> purchaseHistory;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.purchaseHistory = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<List<Product>> getPurchaseHistory() { return purchaseHistory; }

    public void addPurchase(List<Product> purchasedItems) {
        purchaseHistory.add(new ArrayList<>(purchasedItems));
    }

    public void showPurchaseHistory() {
        System.out.println("Historial de compras de " + name + ":");
        for (int i = 0; i < purchaseHistory.size(); i++) {
            System.out.println("Compra #" + (i + 1) + ": " + purchaseHistory.get(i));
        }
    }
}
