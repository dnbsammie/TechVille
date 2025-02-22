package UI;

import Cart.Cart;
import Product.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    private Cart cart = new Cart();

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField quantityField;

    @FXML
    private TextArea cartDisplay;

    @FXML
    private void handleAddProduct() {
        try {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Product product = new Product(name, price, quantity);
            cart.addProduct(product);
            updateCartDisplay();
        } catch (NumberFormatException ex) {
            showAlert("Error", "Ingrese datos válidos");
        }
    }

    @FXML
    private void handleCalculateTotal() {
        double total = cart.calculateTotal();
        showAlert("Total", "El total con descuento es: $" + total);
    }

    @FXML
    private void handleCreateUser() {
        showAlert("Crear Usuario", "Función en desarrollo...");
    }

    @FXML
    private void handleViewCart() {
        showAlert("Carrito", "Mostrando el carrito...");
    }

    private void updateCartDisplay() {
        StringBuilder cartContent = new StringBuilder("Productos en el carrito:\n");
        for (Product p : cart.getProductList()) {
            cartContent.append(p.getName()).append(" - $")
                    .append(p.getPrice()).append(" x ")
                    .append(p.getQuantity()).append("\n");
        }
        cartDisplay.setText(cartContent.toString());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
