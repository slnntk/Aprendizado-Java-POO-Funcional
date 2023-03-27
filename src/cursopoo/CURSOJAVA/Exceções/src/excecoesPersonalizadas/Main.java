package excecoesPersonalizadas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        new Program();
    }
}

class Program{

    List<Resvervation> resvervationList = new ArrayList<>();

    public Program() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Integer numerodoquarto = sc.nextInt();
        Date datein = sdf.parse(sc.next());
        Date dateout = sdf.parse(sc.next());
        resvervationList.add(new Resvervation(numerodoquarto, datein, dateout));
    }



    public void getResvervationList() {


    }

}

class Resvervation{

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    public Resvervation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public long duration(){
        return TimeUnit.MICROSECONDS.convert(checkout.getTime() - checkin.getTime(), TimeUnit.MICROSECONDS);

    }

    public void updateDates(Date checkin, Date checkout){

    }

}
