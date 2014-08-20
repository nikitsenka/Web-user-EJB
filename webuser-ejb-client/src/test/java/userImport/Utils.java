package userImport;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class Utils {
    public static Timestamp getDate(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return new Timestamp(sdf.parse(str).getTime());
    }
}
