package rascunhos.teste.interfaces;

public abstract class Product implements Comparable<Product>{

    private final String name;
    private final Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "," + String.format("%.2f", price);
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
