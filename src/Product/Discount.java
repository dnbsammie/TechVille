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
