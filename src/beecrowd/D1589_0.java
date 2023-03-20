package beecrowd;

import java.util.Scanner;

class D1589_0{
    public static void main(String[] args) {

        CasosDeTeste c1 = new CasosDeTeste();
    }
}

class CasosDeTeste{

    private int raio1;
    private int raio2;
    private int nCasos;
    Scanner sc = new Scanner(System.in);
    public CasosDeTeste() {
        setnCasos(sc.nextInt());
        qtdCasos();
    }

    public void qtdCasos(){

            for (int i = 0;i < getnCasos();i++){
                setRaio1(sc.nextInt());
                setRaio2(sc.nextInt());
                raioConduite(getRaio1(), getRaio2());
            }
    }

    public void raioConduite(int raio1, int raio2){
        System.out.println(raio1+raio2);
    }

    public int getnCasos() {
        return nCasos;
    }

    public void setnCasos(int nCasos) {
        this.nCasos = nCasos;
    }

    public int getRaio1() {
        return raio1;
    }

    public void setRaio1(int raio1) {
        this.raio1 = raio1;
    }

    public int getRaio2() {
        return raio2;
    }

    public void setRaio2(int raio2) {
        this.raio2 = raio2;
    }

}
