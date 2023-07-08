package a;

public class ServicesComparation {

    private Item empresa;
    private Item mlg;

    public ServicesComparation(Item empresa, Item mlg) {
        this.empresa = empresa;
        this.mlg = mlg;
    }

    public Item getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Item empresa) {
        this.empresa = empresa;
    }

    public Item getMlg() {
        return mlg;
    }

    public void setMlg(Item mlg) {
        this.mlg = mlg;
    }
}
