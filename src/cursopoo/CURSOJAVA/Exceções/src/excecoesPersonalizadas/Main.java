package excecoesPersonalizadas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ParseException {
        new Program();
    }
}

class Program {

    List<Resvervation> resvervationList = new ArrayList<>();

    public Program() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.print("Room number: ");
        int numerodoquarto = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date datein = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date dateout = sdf.parse(sc.next());

        Resvervation resvervation = new Resvervation(numerodoquarto, datein, dateout, sdf);
        System.out.println(resvervation.toString());
    }


    public void getResvervationList() {


    }

}

class Resvervation {

    SimpleDateFormat simpleDateFormat;
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    public Resvervation(Integer roomNumber, Date checkin, Date checkout, SimpleDateFormat sdf) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
        this.simpleDateFormat = sdf;
    }

    public long duration() {
        return TimeUnit.DAYS.convert(checkout.getTime() - checkin.getTime(), TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Resvervation: " +
                "Romm " + roomNumber +
                ", check-in: " + simpleDateFormat.format(checkin) +
                ", check-out: " + simpleDateFormat.format(checkout) +
                " " + duration() + " nighits";
    }

}
