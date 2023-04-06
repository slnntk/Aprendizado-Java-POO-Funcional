package arquivosExercicioProposto;

public class Product {

    private String nome;
    private double price;
    private int quantity;

    public Product(String nome, double price, int quantity) {
        this.nome = nome;
        this.price = price;
        this.quantity = quantity;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
