package composicaoProduto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        new Buy(sc, sdf);
    }
}

class Buy{

    public Buy(Scanner sc, SimpleDateFormat sdf) throws ParseException {
        System.out.println("Enter client data: ");
        System.out.print("Nome: ");String nome = sc.nextLine();
        System.out.print("Email: ");String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");Date date = sdf.parse(sc.next());
        new  Client(nome, email, date, sc, sdf);
    }
}

class Client{

    private String nome;
    private String email;
    private String birthDate;


    public Client(String nome, String email, Date birthDate, Scanner sc, SimpleDateFormat sdf) {
        this.nome = nome;
        this.email = email;
        this.birthDate = sdf.format(birthDate);
        System.out.println("Enter order data: ");
        System.out.print("STATUS: ");
        System.out.println(new Order(OrderStatus.valueOf(sc.next()), this, sc));
    }

    @Override
    public String toString() {
        return getNome() + " (" + getBirthDate() + ") - " + getEmail();
    }

    public String getNome() {
        return nome;
    }


    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

}

class Order{

    private Date moment;
    private OrderStatus status;
    private Client client;

    List<OrderItem> orderItemList = new ArrayList<>();

    public Order(OrderStatus status, Client client, Scanner sc) {
        this.moment = Date.from(new Date().toInstant());
        this.status = status;
        this.client = client;
        System.out.print("How many items to this order:? ");
        int nItems = sc.nextInt();
        for (int i = 1;i <= nItems;i++){
            System.out.printf("Enter #%d item data: %n", i);
            OrderItem a = new OrderItem(sc);
            addItem(a);
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("composicaoProduto.Order moment: ");
        sb.append(sdf1.format(getMoment()) + "\n");
        sb.append("composicaoProduto.Order status: ");
        sb.append(getStatus() + "\n");
        sb.append("composicaoProduto.Client: ");
        sb.append(getClient().toString() + "\n");
        sb.append("composicaoProduto.Order items:\n");
        for (OrderItem item : orderItemList) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
        orderItemList.add(item);
    }

    public void removeItem(OrderItem item){
        orderItemList.remove(item);
    }

    public Double total(){
        double sum = 0;
        for(OrderItem o : orderItemList){
            sum += o.subTotal();
        }
    return sum;
    }


    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

}

class OrderItem{

    private Integer quantity;
    private Double price;

    private Product product;


    public OrderItem(Scanner sc) {
        System.out.print("composicaoProduto.Product name: ");String nome = sc.next();
        System.out.print("composicaoProduto.Product price: ");double price = sc.nextDouble();
        System.out.print("Quantity: ");int quantidade = sc.nextInt();
        this.product = (new Product(nome, price));
        this.quantity = quantidade;
        this.price = price;

    }

    public Double subTotal(){

        return getQuantity() * getPrice();

    }

    @Override
    public String toString() {
        return getProduct().getNome()
                + ", $"
                + String.format("%.2f", price)
                + ", Quantity: "
                + quantity
                + ", Subtotal: $"
                + String.format("%.2f", subTotal());
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}


class Product{

    private String nome;
    private Double price;

    public Product() {
    }

    public Product(String nome, Double price) {
        this.nome = nome;
        this.price = price;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

enum OrderStatus{
    PENDING_PAYMENT,
    PROCESSING,
    SHIPPED,
    DELIVERED;
}