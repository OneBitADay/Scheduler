package runner.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class DateUtil {

    public static Optional<Date> StringToDate(SimpleDateFormat simpleDateFormat, String date) {
        Optional<Date> returnDate;

        try {
            returnDate = Optional.of(simpleDateFormat.parse(date));
        }catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return returnDate;
    }
}
