package a.entities;

import java.util.Objects;

public class Item {

    private String item;
    private String codigo;
    private String banco;
    private String descricao;
    private String unidade;
    private int quantidade;
    private Float valorUnitario;
    private Float valorUnitarioBDI;
    private Float valorT;
    private Float valorTBDI;


    public Item(String item, String codigo, String banco, String descricao, String unidade, int quantidade, Float valorUnitario, Float valorUnitarioBDI) {
        this.item = item;
        this.valorUnitario = valorUnitario;
        this.valorUnitarioBDI = valorUnitarioBDI;
    }

    public Item(String[] parameters, int i) {
        this.item = parameters[0];
        this.valorUnitario = Float.valueOf(parameters[4]);
        this.valorUnitarioBDI = Float.valueOf(parameters[5]);
        this.valorT = Float.valueOf(parameters[6]);
        this.valorTBDI = Float.valueOf(parameters[7]);
    }

    public Item(String[] parameters) {
        this.item = parameters[0];
        this.valorUnitario = Float.valueOf(parameters[6]);
        this.valorUnitarioBDI = Float.valueOf(parameters[7]);
    }


    @Override
    public String toString() {
        return item + "," +
                codigo + "," +
                banco + "," +
                descricao + "," +
                unidade + "," +
                quantidade + "," +
                valorUnitario + "," +
                valorUnitarioBDI;
    }


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Float getValorUnitarioBDI() {
        return valorUnitarioBDI;
    }

    public void setValorUnitarioBDI(Float valorUnitarioBDI) {
        this.valorUnitarioBDI = valorUnitarioBDI;
    }
}
