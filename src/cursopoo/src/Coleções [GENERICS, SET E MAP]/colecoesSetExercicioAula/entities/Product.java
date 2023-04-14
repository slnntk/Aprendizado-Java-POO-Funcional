package colecoesSetExercicioAula.entities;

public class Product implements Comparable<Product>{

    private final String name;
    private final Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        return getName().toUpperCase().compareTo(other.getName().toUpperCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null) return false;
        return getPrice() != null ? getPrice().equals(product.getPrice()) : product.getPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getName() + "," + getPrice();
    }

    public String getName() {
        return name;
    }


    public Double getPrice() {
        return price;
    }
}
