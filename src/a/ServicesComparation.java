package a;

public class ServicesComparation {

    private Servicos empresa;
    private Servicos mlg;

    public ServicesComparation(Servicos empresa, Servicos mlg) {
        this.empresa = empresa;
        this.mlg = mlg;
    }

    public Servicos getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Servicos empresa) {
        this.empresa = empresa;
    }

    public Servicos getMlg() {
        return mlg;
    }

    public void setMlg(Servicos mlg) {
        this.mlg = mlg;
    }
}
