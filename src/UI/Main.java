package UI;

import Cart.Cart;
import Product.Product;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private Cart cart = new Cart();
    private TextArea cartDisplay;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Carrito de Compras");

        // Campos de entrada
        TextField nameField = new TextField();
        nameField.setPromptText("Nombre del Producto");

        TextField priceField = new TextField();
        priceField.setPromptText("Precio");

        TextField quantityField = new TextField();
        quantityField.setPromptText("Cantidad");

        Button addButton = new Button("Agregar Producto");
        cartDisplay = new TextArea();
        cartDisplay.setEditable(false);

        Button calculateButton = new Button("Calcular Total");

        // Evento para agregar producto
        addButton.setOnAction(e -> {
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
        });

        // Evento para calcular total
        calculateButton.setOnAction(e -> {
            double total = cart.calculateTotal();
            showAlert("Total", "El total con descuento es: $" + total);
        });

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(nameField, priceField, quantityField, addButton, cartDisplay, calculateButton);

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
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