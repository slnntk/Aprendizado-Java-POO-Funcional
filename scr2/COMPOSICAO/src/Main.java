import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Departamento{

    private String nome;

    public Departamento() {
    }

    public Departamento(String nome, Scanner sc) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

class ContratoPorHora{

    private Date data;
    private Double valorPorHora;
    private Integer horas;

    public ContratoPorHora() {
    }

    public ContratoPorHora(Date data, Double valorPorHora, Integer horas) {
        this.data = data;
        this.valorPorHora = valorPorHora;
        this.horas = horas;
    }

    public double valorTotal(){
        return getValorPorHora() * getHoras();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }
}

enum NivelTrabalhador{

    JUNIOR,
    MID_LEVEL,
    SENIOR;

}

class Trabalhador{

    private String nome;
    private NivelTrabalhador nivel;
    private Double salarioBase;

    private Departamento departamento;
    private List<ContratoPorHora> contratos = new ArrayList<>();

    public Trabalhador() {
    }

    public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public void addContrato(ContratoPorHora contrato){
        contratos.add(contrato);
    }

    public void removeContrato(ContratoPorHora contrato){
        contratos.remove(contrato);
    }

    public Double income(int year, int month){
        double soma = salarioBase;
        Calendar cal = Calendar.getInstance();
        for (ContratoPorHora c : contratos){
            cal.setTime(c.getData());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if (c_month == month && c_year == year) {
                soma += c.valorTotal();
            }

        }
        return soma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelTrabalhador getNivel() {
        return nivel;
    }

    public void setNivel(NivelTrabalhador nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoPorHora> getContratos() {
        return contratos;
    }

}

