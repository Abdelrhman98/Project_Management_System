package projectmanagement;
import java.io.Serializable;
import java.text.ParseException;
import java.util.*;

public class vacation implements Serializable
{
    private int ID;
    private int EmployeeID;
    private Date vacationTime;
    private boolean Status;
    
    public vacation(int EmployeeID, String date) throws ParseException
    {
        validation x = new validation();
        this.vacationTime = x.stringToDate(date);
        this.EmployeeID = EmployeeID;
        this.Status = false;
        this.setId();
    }   
    
    public vacation() {}

    
    public void setId()
    {
        fileManager f = new fileManager();
        int generateId = (((int)f.read("vacId.bin"))+1);
        this.ID = generateId;
        f.write("vacId.bin", generateId);
    }
    public int getId()
    {
         return this.ID;
    }
   
    public void setEmployeeID(int EmployeeID)
    {
      this.EmployeeID=EmployeeID;
    }
    
    public int getEmployeeID()
    {
     return this.EmployeeID;
    }
    
    public void setVacation(String date) throws ParseException
    {
        validation x = new validation();
        this.vacationTime = x.stringToDate(date);
    }
    
    public Date getVacation()
    {
     return this.vacationTime;
    }
    public void setStatus(boolean Status)
    {
      this.Status=Status;
    }
    public boolean getStatus()
    {
        return this.Status;
    }
}
