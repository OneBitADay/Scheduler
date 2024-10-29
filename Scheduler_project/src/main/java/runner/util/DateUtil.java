package runner.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;


public class DateUtil {

    public static Optional<LocalDate> StringToDate(DateTimeFormatter parser,DateTimeFormatter formatter,  String date) {
        //Parse the date
        LocalDate localDate = LocalDate.parse(date,parser);
        localDate.format(formatter);
        return Optional.of(localDate);
    }
}
