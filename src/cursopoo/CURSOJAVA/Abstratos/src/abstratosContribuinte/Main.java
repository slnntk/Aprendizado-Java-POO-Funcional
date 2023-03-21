package abstratosContribuinte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new ReceitaFedera();
    }
}

class ReceitaFedera{

    List<Pessoa> pessoaList = new ArrayList<>();

    public ReceitaFedera() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the number of tax payers: ");int nContrubuintes = sc.nextInt();
        leituraDeDados(sc, nContrubuintes);
        relatorioTaxas();
    }

    public void relatorioTaxas(){

        System.out.println();
        System.out.println("TAXES PAID");
        for (Pessoa p : pessoaList){
            System.out.printf("%s: $ %.2f", p.getNome(), p.imposto());

        }

    }

    public void leituraDeDados(Scanner sc, int nContribuintes){

        Pessoa pessoa = null;

        for (int i = 1;i <= nContribuintes;i++){
            System.out.println("Tax payer #1 data: ");
            System.out.print("Individual or company (i/c)? "); char tipo = sc.next().toLowerCase().charAt(0);
            System.out.print("Name: "); String nome = sc.next();
            System.out.print("Anual income: "); Double renda = sc.nextDouble();

            if (tipo == 'i'){
                System.out.print("Health expenditures: "); Double gastos = sc.nextDouble();
                pessoa = new Fisica(nome, renda, gastos);
            }
            else if (tipo == 'c'){
                System.out.printf("Number of employees");; int nFuncionarios = sc.nextInt();
                pessoa = new Juridica(nome, renda, nFuncionarios);
            }
            pessoaList.add(pessoa);
        }
    }


}


class Fisica extends Pessoa{

    private Double gastos;

    public Fisica(String nome, Double rendaAnual, Double gastos) {
        super(nome, rendaAnual);
        this.gastos = gastos;
    }

    public Double getGastos() {
        return gastos;
    }

    public void setGastos(Double gastos) {
        this.gastos = gastos;
    }




    @Override
    public Double imposto() {
        double imposto = 0;
            if (getRendaAnual() < 20000){
                imposto = getRendaAnual() * 0.15;
            }
            else if (getRendaAnual() > 20000){
                imposto = getRendaAnual() * 0.25;
            }

            if (getGastos() > 0){
                imposto = imposto - (getGastos()*0.50);
            }
        return imposto;
    }


}

class Juridica extends Pessoa{

    private int nFuncionarios;

    public Juridica(String nome, Double rendaAnual, int nFuncionarios) {
        super(nome, rendaAnual);
        this.nFuncionarios = nFuncionarios;
    }

    public int getnFuncionarios() {
        return nFuncionarios;
    }

    public void setnFuncionarios(int nFuncionarios) {
        this.nFuncionarios = nFuncionarios;
    }


    @Override
    public Double imposto() {
        double imposto = 0;
        if (getnFuncionarios() <= 10){
            imposto = getRendaAnual() * 0.16;
        }
        else{
            imposto = getRendaAnual() * 0.14;
        }
        return imposto;
    }

    @Override
    public Double getRendaAnual() {
        return null;
    }

    @Override
    public void setRendaAnual(Double rendaAnual) {

    }
}

abstract class Pessoa{

    private String nome;
    private Double rendaAnual;

    public Pessoa(String nome, Double rendaAnual) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }

    public abstract Double imposto();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(Double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }
}
