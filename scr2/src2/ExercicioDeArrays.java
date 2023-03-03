import java.util.ArrayList;
import java.util.Scanner;

public class ExercicioDeArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new GestorFuncionarios(sc);


    }
}

class GestorFuncionarios{

    private ArrayList<Funcionarios> vetorFuncionarios;

    public GestorFuncionarios(Scanner sc) {
        this.vetorFuncionarios = new ArrayList<>();
        cadastrarFuncionarios (sc);
        aumentarSalario(sc);
        listagem();
    }


    public void cadastrarFuncionarios(Scanner sc){
        System.out.print("Quantos cadastros?: ");
            int n = sc.nextInt();

            for (int i = 0;i < n;i++){
                System.out.printf("Funcionario nº %d%n", i+1);
                System.out.print("ID: ");
                int id = sc.nextInt();
                System.out.print("NOME: ");
                String nome = sc.next();
                System.out.print("SALARIO: ");
                double salario = sc.nextDouble();
                setVetorFuncionarios(new Funcionarios(id, nome, salario));
            }
        }

    public void aumentarSalario(Scanner sc){

        System.out.print("Diga o id do funcionario: ");
        int n = sc.nextInt();
        System.out.print("Porcentagem de aumento: ");
        double aumento = sc.nextDouble();
        System.out.println();
        for (Funcionarios i : getVetorFuncionarios()){
            if (n == i.getId()){
                i.aumento(aumento);
            }
        }
    }

    public void listagem(){
        for (Funcionarios i : getVetorFuncionarios()){
            System.out.printf("%d, %s, %.2f", i.getId(), i.getNome(), i.getSalario());
        }
    }

    public ArrayList<Funcionarios> getVetorFuncionarios() {
        return vetorFuncionarios;
    }

    public void setVetorFuncionarios(Funcionarios temporario) {
        this.vetorFuncionarios.add(temporario);
    }
}

class Funcionarios{

    private int id;
    private String nome;
    private double salario;

    public Funcionarios(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public void aumento(double porcentagem){
        porcentagem = (porcentagem / 100) + 1;
        setSalario(getSalario()*porcentagem);
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
