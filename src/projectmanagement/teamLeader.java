package projectmanagement;
import java.io.Serializable;
import java.util.*;
public class teamLeader extends user implements Serializable{
    ArrayList<report> reports;
    public teamLeader(){this.setFilePath("teamLeader.bin");this.setRole(2);}
    public teamLeader(String fName, String lName,String email, String password, String phoneNumber, String gender,String address)
    {
        this.reports = new ArrayList<>();
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAddress(address);
        this.setId();
        this.setRole(2);
        this.setFilePath("teamLeader.bin");
        this.setImage("");
        this.freeNot();
        this.reports = new ArrayList<>();
    }
    public teamLeader(String fName, String lName,String email, String password, String phoneNumber, String gender,String address, String image)
    {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAddress(address);
        this.setId();
        this.setRole(2);
        this.setFilePath("teamLeader.bin");
        this.setImage(image);
        this.freeNot();
        this.reports = new ArrayList<>();
    }
    public void commit(ArrayList<teamLeader> allLeaders)
    {
        fileManager f = new fileManager();
        f.write(this.getFilePath(), allLeaders);
    }
    public ArrayList<teamLeader> read()
    {
        return (ArrayList<teamLeader>)this.readFromFile(this.getFilePath());
    }
    
    public boolean removeTL(ArrayList<teamLeader> allTL, int id)
    {
        for(teamLeader tl : allTL)
        {
            if(tl.getId() == id)
            {
                allTL.remove(tl);
                return true;
            }
        }
        return false;
    }
    
    public teamLeader search(int id, ArrayList<teamLeader> allLeaders)
    {
        if(!allLeaders.isEmpty())
        {
            for(teamLeader tl : allLeaders)
            {
                if(tl.getId() == id)
                {
                    return tl;
                }
            }
        }
        return new teamLeader();
    }
    
    public void addReport(report r)
    {
        this.reports.add(r);
    }
    
    public ArrayList<report> getReports()
    {
        return this.reports;
    }
}
