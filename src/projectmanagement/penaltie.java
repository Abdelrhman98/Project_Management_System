package projectmanagement;

import java.io.Serializable;

public class penaltie implements Serializable{
    
    private int  id;
    private int empId;
    private String  Reason;
    
    public penaltie(int empId,String  Reason)
    {
        this.empId = empId;
        this.Reason = Reason;
        fileManager f = new fileManager();
        int generateId = (((int)f.read("PenaltieId.bin")) + 1);
        f.write("PenaltieId.bin", generateId);
        this.id = generateId;
    }
    public penaltie(){}
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setEmpId(int id)
    {
        this.empId = id;
    }
    
    public void setReason(String Reason)
    {
        this.Reason = Reason;
    }
     
    public String getReason()
    {
       return this.Reason;
    }
    
    public int  getId()
    {
        return this.id;
    }
    
    public int getEmpId()
    {
        return this.empId;
    }
}
