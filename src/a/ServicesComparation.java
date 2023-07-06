package a;

public class ServicesComparation {

    private Services empresa;
    private Services mlg;

    public ServicesComparation(Services empresa, Services mlg) {
        this.empresa = empresa;
        this.mlg = mlg;
    }

    public Services getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Services empresa) {
        this.empresa = empresa;
    }

    public Services getMlg() {
        return mlg;
    }

    public void setMlg(Services mlg) {
        this.mlg = mlg;
    }
}
