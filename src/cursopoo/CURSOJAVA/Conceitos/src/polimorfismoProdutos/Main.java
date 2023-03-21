package polimorfismoProdutos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Sistema sistema = new Sistema();
        sistema.imprimirPriceTags();
    }
}

class Sistema{

    List<Product> productList = new ArrayList<>();

    public Sistema() throws ParseException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int nProdutos = sc.nextInt();
        for (int i = 1;i <= nProdutos;i++){
            System.out.printf("Product #%d data:%n", i);
            cadastrarProduct(sc);
        }
    }

    public void imprimirPriceTags(){

        System.out.println("%nPRICE TAGS: ");
        for (Product product : productList){
            System.out.println(product.priceTag());
        }

    }

    public void cadastrarProduct(Scanner sc) throws ParseException {

        Product product = new Product();

        System.out.print("Common, used or imported (c/u/i)? ");char typetag = sc.next().charAt(0);
        System.out.print("Name: ");String name = sc.next();
        System.out.print("Price: ");double price = sc.nextDouble();

        if (typetag == 'c'){
            product = cadastrar(name, price);
        } else if (typetag == 'i'){
            System.out.print("Customs fee: ");double customs = sc.nextDouble();
            product = cadastrar(name, price, customs);
        } else if (typetag == 'u'){
            System.out.print("Manufacture date (DD/MM/YYYY): ");String date = sc.next();
            product = cadastrar(name, price, date);
        }
        productList.add(product);
    }

    public Product cadastrar(String name, Double price){
        return new Product(name, price);

    }

    public ImportedProduct cadastrar(String name, Double price,Double customs){
        return new ImportedProduct(name, price, customs);

    }

    public UsedProduct cadastrar(String name, Double price,String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = sdf.parse(date);
        return new UsedProduct(name, price, date1);
    }

    public List<Product> getProductList() {
        return productList;
    }
}

class Product{

    private  String name;
    private Double price;

    public Product() {
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String priceTag(){
        return getName() +  " $ " + getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

class UsedProduct extends Product{

    private Date manufactureDate;

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public final String priceTag(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return  getName() + " (used) " + "$ " + getPrice() + "  (Manufacture date: " + sdf.format(getManufactureDate()) + ")";
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}

class ImportedProduct extends Product{

    private Double customsFee;


    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public final String priceTag(){
        return  getName() + " " + totalPrice() + " (Customs fee: $" + getCustomsFee() + ")";
    }

    public Double totalPrice(){
        return getPrice() + customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }
}