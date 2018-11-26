package projectmanagement;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class employee extends user implements Serializable{
    private ArrayList <penaltie> penalties;
    private ArrayList <vacation> vacations;
    private ArrayList <workTime> workTimes;
    private ArrayList <task> tasks;
    //start of constructor 
    
    // constructor without image
    public employee(String fName, String lName,String email, String password, String phoneNumber, String gender,String address)
    {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAddress(address);
        this.setId();
        this.setRole(1);
        this.vacations = new ArrayList<>();
        this.penalties = new ArrayList<>();
        this.workTimes = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.setFilePath("employee.bin");
        this.setImage("");
        this.freeNot();
    }
    
    // constructor with image
    public employee(String fName, String lName,String email, String password, String phoneNumber, String gender,String address,String image)
    {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAddress(address);
        this.setId();
        this.setRole(1);
        this.vacations = new ArrayList<>();
        this.penalties = new ArrayList<>();
        this.workTimes = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.setFilePath("employee.bin");
        this.setImage(image);
        this.freeNot();
    }
    
    public employee()
    {
        this.setFilePath("employee.bin");
        this.setRole(1);
    }
    //end of constructor 
    
    // start dealing with file
    public void commit(ArrayList<employee> emp)
    {
        fileManager f = new fileManager();
        f.write(this.getFilePath(), emp);
    }
    
    public ArrayList<employee> read()
    {
        return (ArrayList<employee>)this.readFromFile(this.getFilePath());
    }
    // end dealing with file
    
    // start of manage
    public employee search(ArrayList<employee> employees, int id)
    {
        if(!employees.isEmpty())
        {
            if(employees.size() > 0)
            {
                for(employee emp : employees)
                {
                    if( emp.getId() == id )
                        return emp;
                }
            }
        }
        return new employee();
    }
    // end of manage 
    
    // start entry and exit time
    public void setEntryTime()
    {
        workTime newDay = new workTime();
        this.workTimes.add(newDay);
    }
    
    public void setExitTime()
    {
        if(this.workTimes.size()>0)
        this.workTimes.get(this.workTimes.size()-1).SetExitTime();
    }
    // start entry and exit time
    
    //start adding to arrayList
    public boolean addNewTask(task newTask)
    {
        for(task t : this.tasks)
        {
            if(t.getId() == newTask.getId())return false;
        }
        this.tasks.add(newTask);
        return true;
    }
    
    public void addPenaltie(penaltie penal)
    {
        this.penalties.add(penal);
    }

    public void requestVacation(String vacDate) throws ParseException
    {
        vacation vac = new vacation(this.getId(), vacDate);
        this.vacations.add(vac);
    }
    
    public void addWorktime(workTime x)
    {
        this.workTimes.add(x);
    }
    //end adding to arrayList
    
    
    // set task as finish
    public void finishTask(int taskId)
    {
        for(task t : this.tasks)
        {
            if(t.getId() == taskId)t.setStatus(true);
        }
    }
    
    // start getting array lists
    public ArrayList<penaltie> getAllPenalties()
    {
        return this.penalties;
    }
    
    public ArrayList<vacation> getAllVacations()
    {
        return this.vacations;
    }
    
    public ArrayList<task> getFinishedTasks()
    {
        ArrayList<task>finTask = new ArrayList<>();
        for(task t:this.tasks)
        {
            if(t.getStatus() == true)
            {
                finTask.add(t);
            }
        }
        return finTask;
    }
    
    public ArrayList<task> getTasks(int projectId)
    {
        ArrayList<task> taskOfProject = new ArrayList<>();
        for(task t:this.tasks)
        {
            if(t.getProjectId() == projectId)
            {
                taskOfProject.add(t);
            }
        }
        return taskOfProject;
    }
    
    // overload
    public ArrayList<task> getTasks()
    {
        return this.tasks;
    }
    // end getting array lists
    
    // calc all hours over month
    public int getMyHours()
    {
        workTime master = new workTime();
        return master.getWorkHours(this.workTimes);
    }
    
    // not used
    public ArrayList<workTime> getWorkTime()
    {
        return this.workTimes;
    }
    
    // new function
    public ArrayList<task> getPendingTasks()
    {
        ArrayList<task> penTask = new ArrayList<>();
        for(task ta : this.tasks)
        {
            if(!ta.getStatus())
            {
                penTask.add(ta);
            }
        }
        return penTask;
    }
    
    public boolean removeEMP(ArrayList<employee> allEMP, int id)
    {
        for(employee emp : allEMP)
        {
            if(emp.getId() == id)
            {
                allEMP.remove(emp);
                return true;
            }
        }
        return false;
    }
    
}