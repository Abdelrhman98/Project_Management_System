package projectmanagement;
import java.io.Serializable;
import java.util.*;
public class projectManager extends user implements Serializable{
    ArrayList<report> allReports;

    public ArrayList<report> getAllReports() {
        return this.allReports;
    }

    public void addReport(report report) {
        this.allReports.add(report);
    }
    public projectManager(){this.setFilePath("projectManager.bin");}
    public projectManager(String fName, String lName,String email, String password, String phoneNumber, String gender,String address,String image)
    {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAddress(address);
        this.setId();
        this.setRole(3);
        this.setFilePath("projectManager.bin");
        this.setImage(image);
        this.freeNot();
        this.allReports = new ArrayList<>();
    }
    
    public projectManager(String fName, String lName,String email, String password, String phoneNumber, String gender,String address)
    {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAddress(address);
        this.setId();
        this.setRole(3);
        this.setFilePath("projectManager.bin");
        this.setImage("");
        this.freeNot();
        this.allReports = new ArrayList<>();
    }
    
    public boolean removePM(ArrayList<projectManager> allPM, int id)
    {
        for(projectManager pm : allPM)
        {
            if(pm.getId() == id)
            {
                allPM.remove(pm);
                return true;
            }
        }
        return false;
    }
    
    public projectManager search(int id, ArrayList<projectManager> allManagers)
    {
        if(!allManagers.isEmpty())
        {
            for(projectManager p : allManagers)
            {
                if(p.getId() == id)
                {
                    return p;
                }
            }
        }
        return new projectManager();
    }
    
    //dealing with file
    public void commit(ArrayList<projectManager> allManagers)
    {
        fileManager f = new fileManager();
        f.write(this.getFilePath(), allManagers);
    }
    
    public ArrayList<projectManager> read()
    {
        return (ArrayList<projectManager>)this.readFromFile(this.getFilePath());
    }
}