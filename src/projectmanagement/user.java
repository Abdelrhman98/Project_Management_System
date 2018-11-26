package projectmanagement;
import java.io.Serializable;
import java.util.*;

public class user implements Serializable{
    /* start of vars*/
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String phoneNumber;
    private String gender;
    private String address;
    private int id;
    private int role;
    private String filePath;
    private String image;
    private ArrayList<notification> notifications;
    public user(){}
    
    public void freeNot()
    {
        this.notifications = new ArrayList<>();
    }

    
    /* end of overloaded constructor */
    
    /* start of methods */
    /* end of methods */
    public Object readFromFile(String filepath)
    {
        fileManager f = new fileManager();
        return f.read(filepath);
    }
    
    /* start of getter */
    public String getFirstName()
    {
        return this.fName;
    }
    
    public String getLastName()
    {
        return this.lName;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public String getphoneNumber()
    {
        return this.phoneNumber;
    }
    
    public String getGender()
    {
        return this.gender;
    }
    public String getAddress()
    {
        return this.address;
    }
    public int getRole()
    {
        return this.role;
    }
    public int getId()
    {
        return this.id;
    }
    
    public String getImagePath()
    {
        return this.image;
    }
    public String getFilePath()
    {
        return this.filePath;
    }
    /* end of getter */
    
    /* start of setter */
    public void setFirstName(String fName)
    {
        this.fName = fName;
    }
    
    public void setLastName(String lName)
    {
        this.lName = lName;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public void setId()
    {
        fileManager f = new fileManager();
        int generateId = (((int)f.read("generateId.bin"))+1);
        this.id = generateId;
        f.write("generateId.bin", generateId);
    }
    
    public boolean setRole(int role)
    {
        if(role >= 1 && role<=4)
        {
            this.role = role;
            return true;
        }else
        {
            return false;
        }
    }
    public void setImage(String path)
    {
    
        if(path.equals(""))
        {
            if(this.gender.equals("male"))
            {
                this.image = "images/male.jpg";//set default image path here for male
            }
            else
            {
                this.image = "images/female.jpg";//set default image path here for female
            }
        }
        else
        {
            this.image = path;
        }    
    }
    
    public void setFilePath(String path)
    {
        this.filePath = path;
    }
    
    public void update(String fName, String lName, String email, String password, String phoneNumber)
    {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    
    public void addNoti(int toId, int fromId, String message)
    {
        notification n = new notification(toId, fromId, message);
        this.notifications.add(n);
    }
    public ArrayList<notification> getNotifications() 
    {
        return this.notifications;
    }
    /* end of setter */
}
