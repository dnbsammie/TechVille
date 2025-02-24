package controller;

import controller.Store;
import controller.Cart;
import model.User;
import model.Product;
import model.Category;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.List;

public class Controller {
    private Store store = new Store();
    private Cart cart = new Cart();
    private User user;
    private Stage stage;

    public Controller() {
        this.user = new User("Usuario", "correo@example.com");
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML private TabPane tabPane;
    @FXML private GridPane productGrid;
    @FXML private ListView<Product> cartList;
    @FXML private ListView<String> historyList;
    @FXML private Label totalLabel;
    @FXML private ComboBox<Category> categoryFilter;
    @FXML private Label userLabel;
    @FXML private Label userNameLabel;
    @FXML private Label userEmailLabel;
    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Button saveProfileButton;
    @FXML private Label profileNameLabel;
    @FXML private Label profileEmailLabel;

    public void initialize() {
        updateUserInterface();
        initializeProductGrid();
        initializeProfile();
    }

    private void updateUserInterface() {
        if (userLabel != null) {
            userLabel.setText("Bienvenido, " + user.getName());
        }
        userNameLabel.setText("Usuario: " + user.getName());
        userEmailLabel.setText("Correo: " + user.getEmail());
    }

    private void initializeProductGrid() {
        loadProducts(store.getProducts());
        categoryFilter.getItems().addAll(Category.values());
        categoryFilter.setOnAction(e -> filterProducts());
    }

    private void loadProducts(List<Product> products) {
        productGrid.getChildren().clear();
        int row = 0, col = 0;
        for (Product product : products) {
            VBox productBox = createProductBox(product);
            productGrid.add(productBox, col, row);

            col++;
            if (col > 2) {
                col = 0;
                row++;
            }
        }
    }

    private VBox createProductBox(Product product) {
        ImageView imageView = new ImageView(new Image(product.getImagePath()));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        Label nameLabel = new Label(product.getName());
        Label priceLabel = new Label("$" + product.getPrice());
        Button addToCartButton = new Button("Agregar al carrito");
        addToCartButton.setOnAction(event -> addToCart(product));

        VBox productBox = new VBox(5, imageView, nameLabel, priceLabel, addToCartButton);
        productBox.setStyle("-fx-padding: 10px; -fx-border-color: #ddd; -fx-background-color: #f9f9f9; -fx-alignment: center;");
        return productBox;
    }

    @FXML
    private void addToCart(Product product) {
        cart.addToCart(product);
        cartList.getItems().add(product);
        updateTotal();
    }

    public void clearCart() {
        cart.clearCart();
        cartList.getItems().clear();
        updateTotal();
    }

    @FXML
    private void checkout() {
        if (!cartList.getItems().isEmpty()) {
            historyList.getItems().add("Compra realizada: $" + cart.calculateTotal());
            cartList.getItems().clear();
            cart.clearCart();
            updateTotal();
        }
    }

    private void updateTotal() {
        totalLabel.setText("Total: $" + cart.calculateTotal());
    }

    private void filterProducts() {
        Category selectedCategory = categoryFilter.getValue();
        List<Product> filteredList = store.getProducts().stream()
                .filter(p -> selectedCategory == null || p.getCategory() == selectedCategory)
                .toList();
        loadProducts(filteredList);
    }

    @FXML
    private void clearFilters() {
        categoryFilter.setValue(null);
        loadProducts(store.getProducts());
    }

    @FXML
    private void sortByName() {
        List<Product> sortedList = store.getProducts().stream()
                .sorted((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()))
                .toList();
        loadProducts(sortedList);
    }

    @FXML
    private void sortByPrice() {
        List<Product> sortedList = store.getProducts().stream()
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .toList();
        loadProducts(sortedList);
    }

    @FXML
    private void viewProfile() {
        tabPane.getSelectionModel().select(3);
    }

    @FXML
    private void viewCart() {
        tabPane.getSelectionModel().select(1);
    }

    @FXML
    private void viewHistory() {
        tabPane.getSelectionModel().select(2);
    }

    @FXML
    private void goHome() {
        tabPane.getSelectionModel().select(0);
        loadProducts(store.getProducts());
    }

    private void initializeProfile() {
        nameField.setText(user.getName());
        emailField.setText(user.getEmail());
        profileNameLabel.setText("Nombre: " + user.getName());
        profileEmailLabel.setText("Correo: " + user.getEmail());
    }

    @FXML
    private void saveProfile() {
        String newName = nameField.getText().trim();
        String newEmail = emailField.getText().trim();

        if (!newName.isEmpty() && !newEmail.isEmpty()) {
            user.setName(newName);
            user.setEmail(newEmail);
            updateUserInterface();
            initializeProfile();
            showAlert("Perfil actualizado", "Los datos del perfil han sido guardados correctamente.");
        } else {
            showAlert("Error", "Por favor, completa todos los campos.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
