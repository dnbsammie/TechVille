package Cart;

import java.util.ArrayList;
import Product.Product;
import Product.Discount;

public class Cart {
    private ArrayList<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        for (Product p : productList) {
            if (p.getName().equals(product.getName())) {
                p.setQuantity(p.getQuantity() + product.getQuantity());
                return;
            }

            if (product.getPrice() <= 0) {
                System.out.println("El precio no puede ser negativo o cero: " + product.getPrice());
                return;
            }

            if (product.getQuantity() <= 0) {
                System.out.println("La cantidad no puede ser negativa o cero: " + product.getQuantity());
                return;
            }
        }
        productList.add(product);
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public double calculateTotal() {
        double total = 0;
        int totalQuantity = 0;

        for (Product p : productList) {
            total += p.calculateSubTotal();
            totalQuantity += p.getQuantity();
        }

        return Discount.aplicarDiscount(total, totalQuantity);
    }
}