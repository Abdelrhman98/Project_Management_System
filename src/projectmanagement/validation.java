package projectmanagement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class validation {
    public boolean isEmail(String email)
    {
        return (email.length() > 10 && email.substring(email.length() - 4).equals(".com") && email.contains("@"));
    }
    
    public boolean isAlpha(String str)
    {
        return Pattern.matches("[a-zA-Z]+", str);
    }
    
    public boolean isNum(String str)
    {
        return Pattern.matches("[0-9]+", str);
    }
    public String formalName(String str)
    {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    public Date stringToDate(String date) throws ParseException
    {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        return format.parse(date);
    }
    
    public String dateToSring(Date d)
    {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String date = format.format(d);
        return date;
    }
    
    public String FormalDate(String date)
    {
        String[] s = date.split("/");
        if(s.length != 3 || s[2].length() != 4)return "";
        int []d = new int[3];
        d[0] = Integer.parseInt(s[0]);
        d[1] = Integer.parseInt(s[1]);
        d[2] = Integer.parseInt(s[2]);
        if(d[0] > 31 || d[1] > 12 && d[0] <= 0 || d[1] <= 0)return "";
        if(d[0] < 10)
            s[0] = "0" + s[0];
        if(d[1] < 10)
            s[1] = "0"+ s[1];
        
        return s[0] + "/" + s[1] + "/" + s[2];
    }
    
        public String getTime(Date date)
    {
        Date now = new Date();
        long dif = now.getTime()- date.getTime();
        int diff = (int) dif/(60*60*1000);
        if(diff > 24)return Integer.toString(diff/24) + " Day";
        if(diff > 0)return  Integer.toString(diff) + " Hour";
        dif -= (long)diff;
        diff = (int) dif/(60*1000);
        if(diff > 0)return Integer.toString(diff) + " Minute";
        return "a few seconds ago";
    }
}
