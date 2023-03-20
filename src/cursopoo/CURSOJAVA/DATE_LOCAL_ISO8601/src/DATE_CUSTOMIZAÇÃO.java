import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

import static java.time.Duration.between;

public class DATE_CUSTOMIZAÇÃO {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
    //https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.htmlDateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        String date = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data2 = new (String.valueOf(sdf.parse(date)));
        System.out.println(data2);

    }
}