package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringModifier {
    public static String unique_string(String str){
        String new_str = str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new_str;
    }
}
