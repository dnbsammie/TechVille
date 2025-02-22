package Product;

public class Product {
  private String name;
  private double price;
  private int quantity;

  public Product(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double calculateSubTotal() {
    return price * quantity;
  }

  // Meotodos para obtener los productos
  private Product[] getPhones() {
    return new Product[] {
        new Product("Teléfono 1", 200.00, 0),
        new Product("Teléfono 2", 300.00, 0),
        new Product("Teléfono 3", 400.00, 0)
    };
  }

  private Product[] getComputers() {
    return new Product[] {
        new Product("Computadora 1", 1000.00, 0),
        new Product("Computadora 2", 2000.00, 0),
        new Product("Computadora 3", 3000.00, 0)
    };
  }

  private Product[] getTables() {
    return new Product[] {
        new Product("Mesa 1", 100.00, 0),
        new Product("Mesa 2", 200.00, 0),
        new Product("Mesa 3", 300.00, 0)
    };
  }

  private Product[] getTelevisions() {
    return new Product[] {
        new Product("Televisor 1", 500.00, 0),
        new Product("Televisor 2", 600.00, 0),
        new Product("Televisor 3", 700.00, 0)
    };
  }

}
