package Cart;

import java.util.ArrayList;
import Product.Product;
import Product.Discount;

public class Cart {

    private ArrayList<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public double calculateTotal() {
        double total = 0;
        int totalQuantity = 0;

        for (Product product : productList) {
            total += product.calculateSubTotal();
            totalQuantity += product.getQuantity();
        }

        return Discount.aplicarDiscount(total, totalQuantity);
    }
}
