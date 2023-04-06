package excecoesExerciciosAula;

import java.io.Serial;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //SOLUÇÃO BOA\
        new Program();
    }
}

//classe exception
class DomainException extends  RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public DomainException(String msg){
        super(msg);
    }


}

class Program {

    List<Resvervation> resvervationList = new ArrayList<>();

    public Program() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        try{
            System.out.print("Room number: ");int numerodoquarto = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");Date datein = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");Date dateout = sdf.parse(sc.next());
            resvervationList.add(new Resvervation(numerodoquarto, datein, dateout, sdf));

            Resvervation resvervation = resvervationList.get(0);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");datein = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");dateout = sdf.parse(sc.next());
            resvervation.updateDates(datein, dateout);
        } catch (ParseException e){
            System.out.println("Invalid date format");
        } catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
    }
}

class Resvervation {

    SimpleDateFormat simpleDateFormat;
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;


    public Resvervation(Integer roomNumber, Date checkin, Date checkout, SimpleDateFormat sdf){
        if (!checkout.after(checkin)){
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
        this.simpleDateFormat = sdf;
    }

    public long duration() {
        return TimeUnit.DAYS.convert(checkout.getTime() - checkin.getTime(), TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout){
        Date now = new Date();
        if  (checkin.before(now) || checkout.before(now)){
            throw new DomainException("Reservations dates for update must be future dates");
        }
        if (!checkout.after(checkin)){
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkin = checkin;
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
