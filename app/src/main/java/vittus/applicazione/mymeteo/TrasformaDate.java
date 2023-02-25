package vittus.applicazione.mymeteo;

import android.icu.text.SimpleDateFormat;
import android.icu.util.TimeZone;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


public class TrasformaDate {

    public String trasforma_it(String data){
        String g = data.substring(8,10);
        String m = data.substring(5,7);
        String a = data.substring(0,4);
        return g+"/"+m+"/"+a;
    }

    public String trasformaData(String inputFormat, String outputFormat, String inputDate){
        Date parsed = null;
        String outputDate = "";
        SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, Locale.ITALIAN);
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, Locale.ITALIAN);
        df_input.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);

        } catch (ParseException e) {

        }
        return outputDate;
    }
}

