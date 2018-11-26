package projectmanagement;
import java.io.Serializable;
import java.util.*;

public class task implements Serializable
{
    private int id;
    private boolean status;
    private String taskName;
    private int projectId;
    private ArrayList<employee> coders;
    private String taskDesc;
    private Date deadLine;
    
    /* start of constructors */
    
    // default constructor
    public task(){}
    
    // constructor to add one employee
    public task(String name, int pID,employee coder, String desc,Date deadLine)
    {
        
        this.setId();
        this.status = false;
        this.taskName = name;
        this.projectId = pID;
        this.coders = new ArrayList<>();
        this.coders.add(coder);
        this.taskDesc = desc;
        this.deadLine = deadLine;
    }
    
    // constructor to add more than employee
    public task(String name, int pID,ArrayList<employee> coders, String desc,Date deadLine)
    {
        
        this.setId();
        this.status = false;
        this.taskName = name;
        this.projectId = pID;
        this.coders = coders;
        this.taskDesc = desc;
        this.deadLine = deadLine;
    }
    
    //constructor without adding employee
    public task(int id, String name, int pID, String desc,Date deadLine)
    {
        this.setId();
        this.status = false;
        this.taskName = name;
        this.projectId = pID;
        this.taskDesc = desc;
        this.deadLine = deadLine;
    }
    /* end of constructors */
    
    /* start of methods */
    
    
    public boolean AddNewCoder(employee x)
    {
        for (employee coder : this.coders) {
            if (coder.getId() == x.getId()) {
                return false;//this employee already work in this task
            }
        }
        this.coders.add(x);
        return true;
    }
    
    public task search(ArrayList<task> allTasks,int id)
    {
        for(task t : allTasks)
        {
            if(t.id == id)return t;
        }
        return new task();
    }
    /* start of methods */
    
    /* start of setter & getter */
    
    // ID
    public void setId()
    {
        fileManager f = new fileManager();
        int generateId = (((int)f.read("taskId.bin"))+1);
        f.write("taskId.bin", generateId);
        this.id = generateId;
    }
    public int getId()
    {
        return this.id;
    }
    // description
    public void setDesc(String desc)
    {
        this.taskDesc = desc;
    }
    public String getTaskDesc()    
    {
        return this.taskDesc;
    }
    
    //project ID
    public void setProjectID(int pID)
    {
        this.projectId = pID;
    }
    public int getProjectId()
    {
        return this.projectId;
    }
    
    // task Name
    public void setTaskName(String name)
    {
        this.taskName = name;
    }
    public String getTaskName()
    {
        return this.taskName;
    }
    
    // status
    public void setStatus(boolean stat)
    {
        this.status = stat;
    }
    public boolean getStatus()
    {
        return this.status;
    }
    
    //deadLine
    public void setDeadLine(Date deadLine)
    {
        this.deadLine = deadLine;
    }
    public Date getDeadLine()
    {
        return this.deadLine;
    }
    
    // get All employess
    public ArrayList<employee> getAllCoders()
    {
        return this.coders;
    }
    /* end of setter & getter */
}