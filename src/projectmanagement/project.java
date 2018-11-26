package projectmanagement;
import java.io.Serializable;
import java.util.*;

public class project implements Serializable{
    private int ProjectID;
    private String ProjectName;
    private Date deadline;
    private ArrayList<task> ProjectTasks;
    private boolean status;
    /* start of constructors */
    // default constructor
    public project() {}
    
    // constructor without Tasks
    public project(String ProjectName, Date deadline) 
    {
        this.ProjectName = ProjectName;
        this.deadline = deadline;
        this.status = false;
        this.ProjectTasks = new ArrayList<>();
    }
    
    // constructor with tasks
    public project( String ProjectName, Date deadline, ArrayList<task> tasks)
    {
        this.ProjectName = ProjectName;
        this.deadline = deadline;
        this.ProjectTasks = new ArrayList<>();
        this.ProjectTasks = tasks;
        this.status = false;
        this.setID();
    }
    
    public project( String ProjectName, Date deadline, task task) 
    {
        
        this.ProjectName = ProjectName;
        this.deadline = deadline;
        this.ProjectTasks = new ArrayList<>();
        this.ProjectTasks.add(task);
        this.status = false;
        this.setID();
    }
    /* end of constructors */
    
    /* start of methods */
    public boolean commitToFile(ArrayList<project> projects)
    {
        fileManager x = new fileManager();
        boolean y = x.write("project.bin", projects);
        return y;
    }
    
    public ArrayList<project> ReadFromFile()
    {
        fileManager f = new fileManager();
        return (ArrayList<project>)f.read("project.bin");
    }
    public project SearchProject(ArrayList<project> projects, int id)
    {
        for (project project : projects) {
            if (project.ProjectID == id) 
                return project;
        }
       return null;
    }
    
    public float getProgress()
    {
        int suc = 0;
        if(this.ProjectTasks.isEmpty())return 0;
        for(task t : this.ProjectTasks)
        {
            if(t.getStatus())
            {suc++;}
        }
        return (float)(((float)suc/(float)this.ProjectTasks.size())*100);
    }
    
    /* end of methods */
    
    /* start of setter & getter */
    // ID
    public void setID() 
    {
        fileManager f = new fileManager();
        int generateId = (((int)f.read("projectId.bin"))+1);
        f.write("projectId.bin", generateId);
        this.ProjectID = generateId;
    }
    public int getID() 
    {
        return this.ProjectID;
    }
    // project Name
    public void setProjectName(String Pname)
    {
        this.ProjectName= Pname;
    }
    public String getName() 
    {
        return this.ProjectName;
    }
    
    //deadLine
    public Date getProjectDeadLine()
    {
        return this.deadline;
    }
    public void setDeadline (Date deadline)
    {
        this.deadline = deadline;
    }
    
    // status
    public boolean getStatus()
    {
        return this.status;
    }
    public void setProjectStatus(boolean finshed)
    {   //finished or not task status 0 or 1
        this.status = finshed;
    }
    public void addTask(task newTask)
    {
        this.ProjectTasks.add(newTask);
    }
    /* End of setter & getter */
    
    public project searchProject(ArrayList<project> projects, int id)
    {
        if(projects.size() > 0)
        {
            for(project project : projects)
            {
                if( project.getID() == id )
                    return project;
            }
        }
        return null;
    }
    
    public ArrayList<task> getFinishedTasks()
    {
        ArrayList<task> finTasks = new ArrayList<>();
        for(task t : this.ProjectTasks)
        {
            if(t.getStatus())
            {
                finTasks.add(t);
            }
        }
        return finTasks;
    }
    
    public task getTaskById(int id, ArrayList<project> all)
    {
        for(project p : all)
        {
            for(task t : p.getTasks())
            {
                if(t.getId() == id)
                {
                    return t;
                }
            }
        }
        return new task();
    }
    public ArrayList<task> getTasks()
    {
        return this.ProjectTasks;
    }
    
    public project getProjectById(ArrayList<project> allProjects,int id)
    {
        for(project p: allProjects)
        {
            if(p.ProjectID == id)
            {
                return p;
            }
        }
        return new project();
    }
}