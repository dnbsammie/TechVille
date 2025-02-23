<h1 align="center">TECHVILLE MARKET</h1>
<h3 align="center">Aplicación de mercado inteligente</h3>

<h3 align="center">Herramientas/h3>

<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,github,vscode&theme=dark" />
  </a>
</p>

<!-- TANLA DE CONTENIDOS-->
<details>
  <summary>Tabla de contenidos</summary>
  <ol>
    <li><a href="#about">Acerca del reto</a></li>
    <li><a href="#gallery">Galeria</a></li>
    <li><a href="#code">Estructura de código</a></li>
    <li><a href="#credits">Integrantes</a></li>
  </ol>
</details>

---


<!-- acerca del reto -->
<h2 id="about">Acerca Del Reto</h2>
<p>Desarrollar una aplicación de Mercado Inteligente con una interfazgráfica intuitiva, aplicando todos los pilares de la POO:
</p>
<ul>
  <li>Abstracción</li>
  <li>Encapsulamiento</li>
  <li>Herencia</li>
  <li>Polimorfismo</li>
</ul>
<p>El sistema debe permitir la gestión de productos, la compra deartículos y el cálculo de descuentos de manera estructurada y eficiente.</p>
<!-- Galleria -->
<h2 id="gallery">Galería</h2>
<p align="center">
  <img src="#" alt="Image 1" width="30%">
  <img src="#" alt="Image 2" width="30%">
  <img src="#" alt="Image 3" width="30%">
</p>

<!-- Código -->
<h2 id="code">Estructura de Código</h2>
<p>Clases.</p>
<pre>
<code>
package Product;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity

</code>
</pre>
<p>Creamos la clases del producto con sus atributos como: nombre, cantidad, precio</p>
<pre>
<code>
package Product;

public class Discount {
    public static double aplicarDiscount(double total, int cantidad) {
        if (cantidad > 10) {
            return total * 0.85;
        } else if (cantidad > 5) {
            return total * 0.90;
        } else if (cantidad > 3) {
            return total * 0.95;
        }
        return total;
    }
}

</code>
</pre>
<p>Creamos una clase donde valida, si el cliente compro mas 10 productos se ofrece un descuento del 15% y si compra 5 productos o si compra solo 3 porductos</p>
<pre>
<code>
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
    }

    productList.add(product);
  }

  public ArrayList<Product> getProductList() {
    return productList;
  }

  public double calculateSubTotal() {
    double total = 0;
    int totalQuantity = 0;

    for (Product p : productList) {
      total += p.calculateSubTotal();
      totalQuantity += p.getQuantity();
    }

    return Discount.aplicarDiscount(total, totalQuantity);
  }
}
</code>
</pre>
<p>En esta aprte tomamos todos los productos comprados por parte del cliente haciendo una suma total en un arraylist para sacar su subtotal sin aun aplicar el descuento y en calcular toda se ofrece el descuento</p>
<pre>
<code>
package User;

public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
</code>
</pre>
<p>En la siguente clase donde se agregan los datos del usuario como sus nombres y email para que aparezcan en el registro </p>
<p align="center">
  <img src="example-screenshot.png" alt="Example Screenshot" width="600">
</p>
<a href="#">Colocar link de video xd</a>


<!-- Credits -->
<h2 id="credits">Creditos</h2>
<p>
  <strong>Participante 1:</strong> Alejandro Ramirez<br>
  <strong>GitHub: https://github.com/Alejo12680</strong> <a href="https://github.com/Alejo12680"></a>
  <br>
  <strong>Participante 2:</strong> Jhonatan Benavides<br>
  <strong>GitHub:</strong> <a href="#"></a>
  <br>
  <strong>Participante 3:</strong> Samuel Rivera<br>
  <strong>GitHub:</strong> <a href="https://github.com/dnbsammie">https://github.com/dnbsammie</a>
</p>
