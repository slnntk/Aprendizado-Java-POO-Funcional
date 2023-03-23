package excecoesSolucaoMuitoRuim;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

    public Integer duration(){

    }

    public void updateDates(Date checkin, Date checkout){

    }

}
