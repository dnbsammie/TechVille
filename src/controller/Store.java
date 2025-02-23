package controller;

import model.Product;
import model.Category;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products = new ArrayList<>();

    public Store() {
        loadProducts();
    }

    private void loadProducts() {
        products.add(createProduct(Category.AUDIO, "Auriculares Sony", 150, 10, "/resources/audio.png"));
        products.add(createProduct(Category.AUDIO, "Micrófono Shure", 250, 7, "/resources/audio.png"));
        products.add(createProduct(Category.AUDIO, "Bocinas JBL", 300, 5, "/resources/audio.png"));

        products.add(createProduct(Category.COMPUTERS, "Laptop ASUS ROG", 1200, 5, "/resources/computers.png"));
        products.add(createProduct(Category.COMPUTERS, "PC Gamer Alienware", 2500, 3, "/resources/computers.png"));
        products.add(createProduct(Category.COMPUTERS, "Monitor LG 27\"", 350, 6, "/resources/computers.png"));

        products.add(createProduct(Category.GAMING, "Consola PS5", 499, 12, "/resources/gaming.png"));
        products.add(createProduct(Category.GAMING, "Teclado Mecánico Razer", 130, 10, "/resources/gaming.png"));
        products.add(createProduct(Category.GAMING, "Mouse Logitech G Pro", 80, 15, "/resources/gaming.png"));

        products.add(createProduct(Category.SMARTPHONES, "iPhone 15", 999, 8, "/resources/smarthphone.png"));
        products.add(createProduct(Category.SMARTPHONES, "Samsung Galaxy S23", 850, 10, "/resources/smarthphone.png"));
        products.add(createProduct(Category.SMARTPHONES, "Google Pixel 7", 750, 7, "/resources/smarthphone.png"));

        products.add(createProduct(Category.TABLETS, "iPad Pro", 1100, 6, "/resources/tablets.png"));
        products.add(createProduct(Category.TABLETS, "Samsung Galaxy Tab S8", 900, 8, "/resources/tablets.png"));
        products.add(createProduct(Category.TABLETS, "Microsoft Surface Pro", 1200, 4, "/resources/tablets.png"));

        products.add(createProduct(Category.TELEVISION, "Samsung QLED 55\"", 1400, 4, "/resources/television.png"));
        products.add(createProduct(Category.TELEVISION, "LG OLED 65\"", 2200, 3, "/resources/television.png"));
        products.add(createProduct(Category.TELEVISION, "Sony Bravia XR", 1800, 5, "/resources/television.png"));

        products.add(createProduct(Category.VIDEO, "Cámara Canon EOS R5", 3500, 2, "/resources/video.png"));
        products.add(createProduct(Category.VIDEO, "GoPro Hero 11", 500, 10, "/resources/video.png"));
        products.add(createProduct(Category.VIDEO, "Dron DJI Mavic Air 2", 1200, 5, "/resources/video.png"));
    }
    private Product createProduct(Category category, String name, double price, int quantity, String imagePath) {
        String fullPath = getClass().getResource(imagePath) != null ? getClass().getResource(imagePath).toString() : "";
        return new Product(category, name, price, quantity, fullPath);
    }

    public List<Product> getProducts() {
        return products;
    }
}
