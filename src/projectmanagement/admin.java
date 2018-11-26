package projectmanagement;

import java.io.Serializable;
import java.util.ArrayList;

public class admin extends user implements Serializable{
    public admin(){this.setFilePath("admin.bin");}
    //without image
    public admin(String fName, String lName,String email, String password, String phoneNumber, String gender,String address)
    {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAddress(address);
        this.setId();
        this.setRole(4);
        this.setFilePath("admin.bin");
        this.setImage("");
        this.freeNot();
    }
    
    //without image
    public admin(String fName, String lName,String email, String password, String phoneNumber, String gender,String address, String image)
    {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAddress(address);
        this.setId();
        this.setRole(4);
        this.setFilePath("admin.bin");
        this.setImage(image);
        this.freeNot();
    }
    
    public admin search(ArrayList<admin> admins, int id)
    {
        if(!admins.isEmpty())
        {
            for(admin admin : admins)
            {
                if( admin.getId() == id )
                    return admin;
            }
        }
        return new admin();
    }
    
    public void commit(ArrayList<admin>ad)
    {
        fileManager f = new fileManager();
        f.write(this.getFilePath(), ad);
    }
    
    public ArrayList<admin> read()
    {
        return (ArrayList<admin>)this.readFromFile(this.getFilePath());
    }
    
    public boolean removeAD(ArrayList<admin> allAD, int id)
    {
        for(admin ad : allAD)
        {
            if(ad.getId() == id)
            {
                allAD.remove(ad);
                return true;
            }
        }
        return false;
    }
}
