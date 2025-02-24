package model;

import javafx.scene.image.Image;

public class Product {
    private Category category;
    private String name;
    private double price;
    private int stockQuantity;
    private int cartQuantity;
    private Image img;
    private String imgPath;

    public Product(Category category, String name, double price, int stockQuantity, String imgPath) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.cartQuantity = 0;
        this.imgPath = imgPath;
        this.img = new Image(imgPath);
    }

    public Category getCategory() { return category; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public int getCartQuantity() { return cartQuantity; }
    public String getImagePath() { return imgPath; }
    public Image getImage() { return img; }

    public void setCartQuantity(int cartQuantity) {
        if (cartQuantity >= 0 && cartQuantity <= stockQuantity) {
            this.cartQuantity = cartQuantity;
        }
    }

    public void reduceStock() {
        if (cartQuantity > 0) {
            stockQuantity -= cartQuantity;
            cartQuantity = 0;
        }
    }

    @Override
    public String toString() {
        return name + " - $" + price + " (Stock: " + stockQuantity + ")";
    }
}
