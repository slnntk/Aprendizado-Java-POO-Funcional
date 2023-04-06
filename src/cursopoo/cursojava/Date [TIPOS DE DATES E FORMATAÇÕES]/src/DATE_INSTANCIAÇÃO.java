package src;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DATE_INSTANCIAÇÃO {
    public static void main(String[] args) {

        System.out.println("------------DATA/HORA NOW--------------------");

        LocalDate d01 = LocalDate.now();
        System.out.printf("DATA LOCAL SEM HORARIO : ");
        System.out.println(d01);

        LocalDateTime d02 = LocalDateTime.now();
        System.out.printf("DATA LOCAL COM HORARIO : ");
        System.out.println(d02);

        Instant d03 = Instant.now();
        System.out.printf("DATA GLOBAL COM HORARIO : ");
        System.out.println(d03);

        System.out.println("---------------------------------------------");

        System.out.println("--------------TEXTO ISO 8601-----------------");
        LocalDate d04 = LocalDate.parse("2023-06-03");
        System.out.println(d04);

        LocalDateTime d05 = LocalDateTime.parse("2023-06-03T15:05:26");
        System.out.println(d05);

        Instant d06 = Instant.parse("2023-06-03T15:05:26Z");
        System.out.println(d06);

        Instant d07 = Instant.parse("2023-06-03T15:05:26-03:00");
        System.out.println(d07);

        System.out.println("---------------------------------------------");

        System.out.println("--------------TEXTO CUSTOMIZADO--------------");

        //https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);
        System.out.println(d08);

        LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt2);
        System.out.println(d09);

        LocalDate d010 = LocalDate.of(2022,07,20);
        System.out.println(d010);

        LocalDateTime d011 = LocalDateTime.of(2022,07,20, 01,30,30);
        System.out.println(d011);

        System.out.println("---------------------------------------------");


    }
}