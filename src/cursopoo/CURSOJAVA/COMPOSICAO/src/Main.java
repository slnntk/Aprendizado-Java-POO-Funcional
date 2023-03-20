import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter department's name: ");
        Department department = new Department(sc.next(), sc);
        department.addWorker(department, sc);



    }
}

class Worker{

    private String nome;
    private WokerLevel level;
    private Double baseSalary;

    private List<HourContract> contracts = new ArrayList<>();
    private Department department;

    public Worker(String nome, WokerLevel level, Double baseSalary, Department department, Scanner sc) throws ParseException {
        this.nome = nome;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
        System.out.println("How many contracts to this worker?");
        addInitialContract(sc.nextInt(), sc);
        payCheckStub(sc);
    }

    public void payCheckStub(Scanner sc) throws ParseException {
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
        Date date = sdf.parse(sc.next());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int cal_month = 1 + cal.get(Calendar.MONTH);int cal_year = cal.get(Calendar.YEAR);
        System.out.println("Name:" + this.getNome());
        income(cal_year, cal_month, getBaseSalary(), sc, sdf);
    }

    public Double income(int year, int month, double baseSalary,Scanner sc, SimpleDateFormat sdf) {
        double soma = baseSalary;
        int cal_month = 0;
        int cal_year = 1;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts){
            cal.setTime(c.getDate());
            cal_month = 1 + cal.get(Calendar.MONTH);
            cal_year =  cal.get(Calendar.YEAR);
            if (cal_month == month && cal_year == year){
                soma += c.totalValue();
            }
        }
        System.out.println("Department: " + getDepartment().getNome());
        System.out.println("Income for " + cal_month + "/" + cal_year + ": " + String.format("%.2f", soma));
        return soma;
    }

    public void addInitialContract(int n, Scanner sc) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 1; i <= n;i++){
            System.out.printf("Enter contract #%d data: %n", i);
            System.out.print("Date (DD/MM/YYYY): ");Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");int hours = sc.nextInt();
            addContract(new HourContract(contractDate, valuePerHour, hours));
        }

    }

    public void addContract(HourContract contract){
        this.contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        this.contracts.remove(contract);
    }



    public String getNome() {
        return nome;
    }


    public WokerLevel getLevel() {
        return level;
    }

    public void setLevel(WokerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public Department getDepartment() {
        return department;
    }

}


class HourContract{

    private Date date;
    private Double valuePerHour;
    private Integer hours;

    public HourContract() {
    }

    public HourContract(Date date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public Double totalValue(){
        return getValuePerHour() * getHours();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}

enum WokerLevel{

    JUNIOR,
    MID_LEVEL,
    SENIOR;

}

class Department{

    private String nome;

    public Department() {
    }

    public Department(String nome, Scanner sc) {
        this.nome = nome;
    }



    public void addWorker(Department department, Scanner sc) throws ParseException {
        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = sc.next();
        System.out.print("Level: ");
        String workerLevel = sc.next();
        WokerLevel level = WokerLevel.valueOf(workerLevel);
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        System.out.println(workerName);
        new Worker(workerName, level, baseSalary, department, sc);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}