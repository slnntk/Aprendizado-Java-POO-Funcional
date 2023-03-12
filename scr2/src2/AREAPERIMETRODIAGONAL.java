import java.util.Locale;
import java.util.Scanner;

public class AREAPERIMETRODIAGONAL {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva a largura e altura, respectivamente: ");
        Retangulo r1 = new Retangulo(sc.nextDouble(), sc.nextDouble());
        System.out.printf("AREA = %.2f%nPERIMETRO = %.2f%nDIAGONAL = %.2f%n",r1.Area(), r1.Perimetro(), r1.Diagonal());
    }
}

class Retangulo{

    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        setLargura(largura);
        setAltura(altura);
    }

    public double Area(){
        return getLargura() * getAltura();
    }

    public double Perimetro(){
        return getLargura()*2 + getAltura()*2;
    }

    public double Diagonal(){
        return Math.sqrt(Math.pow(getLargura(), 2) + Math.pow(getAltura(), 2));
    }



    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}