package projectmanagement;

import java.io.Serializable;
import java.util.*;
import java.text.SimpleDateFormat;

public class workTime implements Serializable{
    private Date EntryTime;
    private Date ExitTime;
    public workTime()
    {
        this.EntryTime = new Date();
        this.ExitTime = new Date();
    }   
    
    public void SetEntryTime(Date EntryTime) 
    {
        EntryTime = new Date();
        this.EntryTime = EntryTime ;
    }
    
     public Date GetEntryTime() 
    {
        return this.EntryTime ;
    }
     public void SetExitTime()
    {
        this.ExitTime = new Date();
    }
     
    public Date GetExitTime() 
    {
        return this.ExitTime ;
    }
     
    public int[] calcAllhours()
    {
        int arr[] = new int [2];
        long dif = this.ExitTime.getTime() - this.EntryTime.getTime();
        arr[0] = (int) (dif / (60 * 60 * 1000));
        dif -= arr[0] * 60 * 60 * 1000;
	arr[1] = (int)(dif / (60 * 1000));
        return arr;
    }
    public int getMonth()
    {
        SimpleDateFormat form = new SimpleDateFormat("MM");
        String month = form.format(this.ExitTime);
        return (int)Integer.parseInt(month);
    }
     
    public int getWorkHours(ArrayList<workTime> wTime)
    {
        Date m = new Date();
        SimpleDateFormat form = new SimpleDateFormat("MM");
        String mon = form.format(m);
        int month = (int)Integer.parseInt(mon);
        int allHours = 0;
        int min = 0;
        if(wTime.size() > 0)
        {
            wTime.get( wTime.size() - 1).SetExitTime();
            for(workTime work : wTime)
            {
                if(work.getMonth() == month)
                {
                    int []arr = work.calcAllhours();
                    allHours += arr[0];
                    min += arr[1];
                    if(min >= 60)
                    {
                        allHours += 1;
                        min -= 60;
                    }
                }
            }
            return allHours;
        }
        return 0;
    }
}