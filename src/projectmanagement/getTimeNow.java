package projectmanagement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getTimeNow {
    public void getTimeNow(int []arr)
    {
        Date x = new Date();
        SimpleDateFormat y = new SimpleDateFormat("HH DD MM YYYY");
        String []str = y.format(x).split(" ");
        int index = 0;
        for(String s:str)
        {
            arr[index] = Integer.parseInt(s);
            index++;
        }
        
    }
    public int [] getTimeNow()
    {
        Date x = new Date();
        SimpleDateFormat y = new SimpleDateFormat("hh dd mm yyyy");
        String []str = y.format(x).split(" ");
        int []arr = new int[5];
        int index = 0;
        for(String s:str)
        {
            arr[index] = Integer.parseInt(s);
            index++;
        }
        return arr;
    }
}
