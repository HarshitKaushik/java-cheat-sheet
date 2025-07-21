import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateExamples {

  public static void main(String[] args) {
    LocalDate d1 = LocalDate.now();
    System.out.println(d1);

    LocalDate d2 = LocalDate.parse("2025-07-31");
    System.out.println(d2);

    LocalDate d3 = d1.plusDays(7);
    System.out.println(d3);

    LocalTime time = LocalTime.MAX;
    time = time.minusHours(2);
    System.out.println(time);

    LocalDateTime d4 = LocalDateTime.of(2025, 7, 21, 9, 37, 0);
    System.out.println(d4);

    LocalDateTime d5 = LocalDateTime.now();
    System.out.println(d5.isAfter(d4));

    ZoneId zoneId = ZoneId.of("Europe/Paris");
    ZonedDateTime zonedDateTime = ZonedDateTime.of(d5, zoneId);
    System.out.println(zonedDateTime);

    LocalDate d6 = LocalDate.now();
    LocalDate d7 = d6.plus(Period.ofMonths(2));
    
    System.out.println(d6);
    System.out.println(d7);

    LocalDateTime localDateTime = LocalDateTime.now();
    localDateTime  
      .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
      .withLocale(Locale.UK));
  }
}