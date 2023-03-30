package beecrowd.exerciciosResolvidos;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class D1047_3 {
    public static void main(String[] args) {
        new JogoM();
    }
}

class JogoM extends Hora{

    private Date start;
    private Date end;


    public JogoM() {
        Scanner sc = new Scanner(System.in);
        start = new Hora(sc.nextInt(), sc.nextInt()).getDate();
        end = new Hora(sc.nextInt(), sc.nextInt()).getDate();
        duration();
    }

    public void duration() {
        int minutostotais = (int) TimeUnit.MINUTES.convert(end.getTime() - start.getTime(), TimeUnit.MILLISECONDS);
        if (minutostotais <= 0) {
            minutostotais += 1440;
        }
        System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n", minutostotais/60,minutostotais%60);

    }
}

class Hora{

    private int hora;
    private int minuto;

    private Date date;

    public Hora() {
    }

    public Hora(int hora, int minuto){
        this.hora = hora;
        this.minuto = minuto;
        this.date = hourAndMinut(minuto, hora);
    }

    public Date hourAndMinut(int minito, int hora){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hora);
        cal.set(Calendar.MINUTE, minito);
        return cal.getTime();
    }

    public Date getDate() {
        return date;
    }
}