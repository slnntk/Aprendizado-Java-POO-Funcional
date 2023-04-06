package rascunhos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Scanner sc = new Scanner(System.in);
        System.out.print("Withdrawal date (dd/MM/yyyy hh:mm): ");LocalDateTime withdrawDate = LocalDateTime.parse("25/06/2018 10:30", dtf);
        System.out.print("Return date (dd/MM/yyyy hh:mm): ");LocalDateTime returnDate = LocalDateTime.parse("27/06/2018 11:40", dtf);
        System.out.println(withdrawDate);
        System.out.println(returnDate);


        int duration = (int) TimeUnit.DAYS.convert(returnDate.getSecond() - withdrawDate.getSecond(), TimeUnit.SECONDS);
        System.out.println(duration);
        if (duration % 24 != 0){
            System.out.println((duration % 24) + 1);
        }
        else{
            System.out.println(duration);
        }
    }
}

//25/06/2018 10:30
//27/06/2018 11:40
