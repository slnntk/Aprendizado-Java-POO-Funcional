package beecrowd;

import java.util.Scanner;

public class D1019_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Conversor conversor = new Conversor(n);
        Tempo tempoConvertido = conversor.converterTempo();
        System.out.println(tempoConvertido.toString());

    }

    static class Conversor {

        private int tempo;

        public Conversor(int tempo) {
            this.setTempo(tempo);
        }

        public Tempo converterTempo() {
            Tempo tempoConvertido = new Tempo(getTempo());
            tempoConvertido.converter(this.getTempo());
            return tempoConvertido;
        }

        public int getTempo() {
            return tempo;
        }

        public void setTempo(int tempo) {
            this.tempo = tempo;
        }
    }

    static class Tempo{

        private int qtdSegundos, horas, minutos, segundos;

        public Tempo(int numero) {
            setQtdSegundos(numero);
        }

        private void converter (int QTDsegundos){
            setHoras(getQtdSegundos() / 3600);
            setMinutos((getQtdSegundos() % 3600) / 60);
            setSegundos((getQtdSegundos() % 3600) % 60);
        }

        public int getQtdSegundos() {
            return qtdSegundos;
        }

        public void setQtdSegundos(int qtdSegundos) {
            this.qtdSegundos = qtdSegundos;
        }

        public int getHoras() {
            return horas;
        }

        public void setHoras(int horas) {
            this.horas = horas;
        }

        public int getMinutos() {
            return minutos;
        }

        public void setMinutos(int minutos) {
            this.minutos = minutos;
        }

        public int getSegundos() {
            return segundos;
        }

        public void setSegundos(int segundos) {
            this.segundos = segundos;
        }

        @Override
        public String toString() {
            return this.getHoras() + ":" + this.getMinutos() + ":" + this.getSegundos();
        }
    }
}
