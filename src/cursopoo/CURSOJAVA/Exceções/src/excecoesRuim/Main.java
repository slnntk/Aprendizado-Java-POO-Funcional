package excecoesRuim;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ParseException {
        //SOLUÇÃO RUIM
        new Program();
    }
}

class Program {

    List<Resvervation> resvervationList = new ArrayList<>();

    public Program() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);


        startReservation(sc, sdf);
        String error = updateReservation(resvervationList.get(0), sc, sdf);
        if (error != null){
            System.out.println("Error in reservation: " + error);
        }else{
            System.out.println("Reservation: " + resvervationList.get(0).toString());
        }
    }

    public void startReservation(Scanner sc, SimpleDateFormat sdf) throws ParseException {
        System.out.print("Room number: ");int numerodoquarto = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");Date datein = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");Date dateout = sdf.parse(sc.next());

        isCorrectDate(datein, dateout);
        createReservation(numerodoquarto,datein, dateout, sdf);
    }

    public void createReservation(Integer numerodoquarto, Date in, Date out,SimpleDateFormat sdf) throws ParseException {
        resvervationList.add(new Resvervation(numerodoquarto, in, out, sdf));
    }

    public String updateReservation(Resvervation resvervation,Scanner sc, SimpleDateFormat sdf) throws ParseException {
        System.out.println();
        System.out.println("Enter data to update the reservation:");
        System.out.print("Check-in date (dd/MM/yyyy): ");Date datein = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");Date dateout = sdf.parse(sc.next());
        return resvervation.updateDates(datein,dateout);
    }

    public boolean isCorrectDate(Date in, Date on){
        if (in.after(on)){
            return false;
        }
        else{
            return true;
        }
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

    public String updateDates(Date checkin, Date checkout) {
        Date now = new Date();
        if  (checkin.before(now) || checkout.before(now)){
            return "Reservations dates for update must be future dates";
        }
        if (!checkout.after(checkin)){
            return "Check-out date must be after check-in date";
        }
        this.checkin = checkin;
        this.checkout = checkout;

        return null;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Romm " + roomNumber +
                ", check-in: " + simpleDateFormat.format(checkin) +
                ", check-out: " + simpleDateFormat.format(checkout) +
                " " + duration() + " nighits";
    }

}
