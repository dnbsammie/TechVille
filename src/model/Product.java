package model;

import javafx.scene.image.Image;

public class Product {
    private Category category;
    private String name;
    private double price;
    private int quantity;
    private Image img;
    private String imgPath;

    public Product(Category category, String name, double price, int quantity, String imgPath) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imgPath = imgPath;
        this.img = new Image(imgPath);
    }

    public Category getCategory() { return category; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Image getImage() { return img; }
    public String getImagePath() { return imgPath; }
    
    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
