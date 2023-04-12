package rascunhos.genericsteste2.entities;

public class Product implements Comparable<Product>{

    private String name;
    private Double price;

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

    @Override
    public int compareTo(Product o) {
        return getPrice().compareTo(o.getPrice());
    }
}
