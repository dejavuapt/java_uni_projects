import java.util.Locale;
import java.time.format.DateTimeFormatter;

public interface GlobalConstants{
    static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd",Locale.US);
}