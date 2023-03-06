import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DATE_CUSTOMIZAÇÃO {
    public static void main(String[] args) {

//https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.htmlDateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d04 = LocalDate.parse("2023-06-03");
        LocalDateTime d05 = LocalDateTime.parse("2023-06-03T15:05:26");
        Instant d06 = Instant.parse("2023-06-03T15:05:26Z");

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern()

    }
}