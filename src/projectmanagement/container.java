package projectmanagement;
import java.io.Serializable;
import java.text.ParseException;
import java.util.*;

public class container implements Serializable {
    public ArrayList<employee> employees;
    public ArrayList<teamLeader> teamLeaders;
    public ArrayList<projectManager> projectManagers;
    public ArrayList<admin> admins;
    public ArrayList<project> projects;
    public ArrayList<vacation> vacations;
    //public ArrayList<penaltie> penalties;
    public int currentUserRole;
    public boolean activeSession;
    public employee empSession;
    public teamLeader TLSession;
    public projectManager PMSession;
    public admin adSession;
    public int activeId;
    public int userId;
    public container()
    {
        this.employees = new ArrayList<>();
        this.teamLeaders = new ArrayList<>();
        this.projectManagers =  new ArrayList<>();
        this.admins = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.vacations = new ArrayList<>();
        //this.penalties = new ArrayList<>();
        this.activeSession = false;
        admin masterAdmin = new admin();
        project masterProject = new project();
        projectManager masterPM = new projectManager();
        teamLeader masterTL = new teamLeader();
        employee masterEmployee = new employee();
        
        this.admins = masterAdmin.read();
        this.projectManagers = masterPM.read();
        this.teamLeaders = masterTL.read();
        this.employees = masterEmployee.read();
        this.projects = masterProject.ReadFromFile();
    }//end of constructor
    
    public task getTaskById(int id)
    {
        ArrayList<task> tasks = new ArrayList<>();
        tasks = this.getAllTasks();
        for(task t : tasks)
        {
            if(t.getId() == id){return t;}
        }
        return new task();
    }
    
    public ArrayList<String> validAll(String fname,String lname,String email,String password,String phone,String gender,String address,int role)
    {
        ArrayList<String> strErr = new ArrayList<>();
        validation valid = new validation();
        
        fname = valid.formalName(fname);
        lname = valid.formalName(lname);
        if(role<1 || role>4)
        {
            strErr.add("role not correct");
        }
        if(!valid.isAlpha(fname))
        {
            strErr.add("First Name not valid");
        }
        if(!valid.isAlpha(lname))
        {
            strErr.add("Last Name not valid");
        }
        if(!valid.isEmail(email))
        {
            strErr.add("Email Not valid");
        }
        if(password.length() < 8 || valid.isNum(password))
        {
            String passErr =  new String();
            boolean len = false;
            if(password.length() < 8)
            {
                passErr = "password should be more than 8 character";
                len = true;
            }
            if(valid.isNum(password))
            {
                passErr += (len)?" and contain at least 1 ":"password should contain letter";
            }
            strErr.add(passErr);
        }
        if(!valid.isNum(phone) || phone.length() != 11)
        {
            strErr.add("phone Number not valid");
        }
        boolean flag = false;
        for (admin admin : this.admins) {
            if(admin.getEmail().equals(email) && admin.getRole()!= role)
            {
                strErr.add("Email is already exist in Admin's emails");
                flag = true;
                break;
            }
        }
        if(!flag)
        {
            for(projectManager pm : this.projectManagers)
            {
                if(pm.getEmail().equals(email) && pm.getRole() != role)
                {
                    strErr.add("Email is already exist in project Manager's emails");
                    flag = true;
                    break;
                }
            }
            if(!flag)
            {
                for(teamLeader tl : this.teamLeaders)
                {
                    if(tl.getEmail().equals(email) && tl.getRole() != role)
                    {
                        strErr.add("Email is already exist in team leader's emails");
                        flag = true;
                        break;
                    }//end of if
                }// end of for 
            }//end of flah team leader
            if(!flag)
            {
                for(employee emp : this.employees)
                {
                    if(emp.getEmail().equals(email) && emp.getRole()!=role)
                    {
                        strErr.add("Email is already exist in employees' emails");
                        break;
                    }//end of if
                }
            }
        }//end of flag project manager
        
        return strErr;
    }
    
    public ArrayList<String> validAllAdd(String fname,String lname,String email,String password,String phone,String gender,String address,int role)
    {
        ArrayList<String> strErr = new ArrayList<>();
        validation valid = new validation();
        
        fname = valid.formalName(fname);
        lname = valid.formalName(lname);
        if(role<1 || role>4)
        {
            strErr.add("role not correct");
        }
        if(!valid.isAlpha(fname))
        {
            strErr.add("First Name not valid");
        }
        if(!valid.isAlpha(lname))
        {
            strErr.add("Last Name not valid");
        }
        if(!valid.isEmail(email))
        {
            strErr.add("Email Not valid");
        }
        if(password.length() < 8 || valid.isNum(password))
        {
            String passErr =  new String();
            boolean len = false;
            if(password.length() < 8)
            {
                passErr = "password should be more than 8 character";
                len = true;
            }
            if(valid.isNum(password))
            {
                passErr += (len)?" and contain at least 1 ":"password should contain letter";
            }
            strErr.add(passErr);
        }
        if(!valid.isNum(phone) || phone.length() != 11)
        {
            strErr.add("phone Number not valid");
        }
        boolean flag = false;
        for (admin admin : this.admins) {
            if(admin.getEmail().equals(email))
            {
                strErr.add("Email is already exist in Admin's emails");
                flag = true;
                break;
            }
        }
        if(!flag)
        {
            for(projectManager pm : this.projectManagers)
            {
                if(pm.getEmail().equals(email) )
                {
                    strErr.add("Email is already exist in project Manager's emails");
                    flag = true;
                    break;
                }
            }
            if(!flag)
            {
                for(teamLeader tl : this.teamLeaders)
                {
                    if(tl.getEmail().equals(email))
                    {
                        strErr.add("Email is already exist in team leader's emails");
                        flag = true;
                        break;
                    }//end of if
                }// end of for 
            }//end of flah team leader
            if(!flag)
            {
                for(employee emp : this.employees)
                {
                    if(emp.getEmail().equals(email))
                    {
                        strErr.add("Email is already exist in employees' emails");
                        break;
                    }//end of if
                }
            }
        }//end of flag project manager
        
        return strErr;
    }
    public ArrayList<String> updateUser(int id, String fname,String lname,String email,char[] pass,String phone,String gender,String address, int role)
    {
        String password = new String(pass);
        ArrayList<String> strErr = this.validAll(fname, lname, email, password, phone, gender, address, role);
        if(strErr.isEmpty())
        {
            if(role == 1)
            {
                employee masterEmp = new employee();
                employee upEmp = masterEmp.search(this.employees, id);
                if(upEmp.getId() == 0)
                {
                    strErr.add("this employee not found");
                }
                else
                {
                    upEmp.update(fname, lname, email, password, phone);
                    masterEmp.commit(this.employees);
                }
            }
            else if(role == 2)
            {
                teamLeader masterTL = new teamLeader();
                teamLeader upTL = masterTL.search(id, this.teamLeaders);
                if(upTL.getId() == 0)
                {
                    strErr.add("this teamLeader not found");
                }
                else
                {
                    upTL.update(fname, lname, email, password, phone);
                    masterTL.commit(this.teamLeaders);
                }
            }
            else if(role == 3)
            {
                projectManager masterPM = new projectManager();
                projectManager upPM = masterPM.search(id, this.projectManagers);
                if(upPM.getId() == 0)
                {
                    strErr.add("This Project Manager not found");
                }
                else
                {
                    upPM.update(fname, lname, email, password, phone);
                    masterPM.commit(this.projectManagers);
                }
            }
            else if(role == 4)
            {
                admin masterAD = new admin();
                admin upAD = masterAD.search(admins, id);
                if(upAD.getId() == 0)
                {
                    strErr.add("This Admin not found");
                }else
                {
                    upAD.update(fname, lname, email, password, phone);
                    masterAD.commit(admins);
                }
            }
        }
        return strErr;
    }
    
    public ArrayList<String> addNewUser(String fname,String lname,String email,char[] pass,String phone,String gender,String address,int role,String image)
    {
        String password = new String(pass);
        
        ArrayList<String> strErr = new ArrayList<>();
        strErr = this.validAllAdd(fname, lname, email, password, phone, gender, address, role);
        if(strErr.isEmpty())
        {
            switch(role)
            {
                case 1:
                    employee newEmp = new employee(fname, lname, email, password, phone, gender, address, image);
                    this.employees.add(newEmp);
                    newEmp.commit(this.employees);
                    break;
                case 2:
                    teamLeader newTL = new teamLeader(fname, lname, email, password, phone, gender, address, image);
                    this.teamLeaders.add(newTL);
                    newTL.commit(this.teamLeaders);
                    break;
                case 3:
                    projectManager newPM = new projectManager(fname, lname, email, password, phone, gender, address, image);
                    this.projectManagers.add(newPM);
                    newPM.commit(this.projectManagers);
                    break;
                case 4:
                    admin newAdmin = new admin(fname, lname, email, password, phone, gender, address,image);
                    this.admins.add(newAdmin);
                    newAdmin.commit(this.admins);
                    break;
            }//end of switch
        }//end of add new user
        return strErr;
    }
    
    public boolean removeUser(int id)
    {
        boolean res = false;
        
            employee masterEmp = new employee();
            res = masterEmp.removeEMP(this.employees, id);
            masterEmp.commit(this.employees);
             if(!res)                  
             {
                 teamLeader masterLeader = new teamLeader();
                res = masterLeader.removeTL(this.teamLeaders, id);
                masterLeader.commit(this.teamLeaders);
             }
             else if(!res)
             {
                projectManager masterPM = new projectManager();
                res = masterPM.removePM(this.projectManagers, id);
                masterPM.commit(this.projectManagers);
             }
             else if(!res)
             {
                admin masterAD = new admin();
                res = masterAD.removeAD(this.admins, id);
                masterAD.commit(this.admins);
             }
        return res;
    }
    
    public ArrayList<String> addNewTask(String taskName, int projectId, employee coder, String desc, String deadLine) throws ParseException
    {
        ArrayList<String> err = new ArrayList<>();
        validation v = new validation();
        deadLine = v.FormalDate(deadLine);
        if(deadLine.equals("")){
            err.add("this date not valid");
        }
        else
        {
            Date dead = v.stringToDate(deadLine);
            task newTask = new task(taskName, projectId, coder, desc, dead);
            for(int i=0 ; i < this.projects.size(); i++)
            {
                if(this.projects.get(i).getID() == projectId)
                {

                    this.projects.get(i).addTask(newTask);
                    project masterProject = new project();
                    masterProject.commitToFile(this.projects);
                    
                }
            }
        
            for(int i = 0; i< this.employees.size(); i++)
            {
                if(this.employees.get(i).getId() == coder.getId())
                {
                    this.employees.get(i).addNewTask(newTask);
                    //int toId, int fromId, String messageassign
                    this.employees.get(i).addNoti(this.employees.get(i).getId(),this.activeId,"New task was assigned to you! ");
                    employee masterEmployee = new employee();
                    masterEmployee.commit(this.employees);
                }//end of if
            }//end of for
        }//end of else
        return err;
    }
    
    public void addNewProject(String projectName, String deadLine) throws ParseException
    {
        validation v = new validation();
        Date dead = v.stringToDate(v.FormalDate(deadLine));
        project newProject = new project(projectName, dead);
        this.projects.add(newProject);
        project masterProject = new project();
        masterProject.commitToFile(this.projects);
    }
    
    public int login(String email,char[] pass)
    {
        String password = new String(pass);
        
        if(!this.employees.isEmpty())
        {
            for(employee emp:this.employees)
            {
                if(email.equals(emp.getEmail()) && emp.getPassword().equals(password))
                {    
                    this.empSession = new employee();
                    this.empSession = emp;
                    this.empSession.setEntryTime();
                    this.currentUserRole = 1;
                    this.activeSession = true;
                    this.activeId = emp.getId();
                    return 1;
                }
            }
        }
        
        if(!this.teamLeaders.isEmpty())
        {
            for(teamLeader tl : this.teamLeaders)
            {
                if(tl.getEmail().equals(email) && tl.getPassword().equals(password))
                {
                    this.TLSession = new teamLeader();
                    this.TLSession = tl;
                    this.currentUserRole = 2;
                    this.activeSession = true;
                    this.activeId = tl.getId();
                    return 2;
                }
            }
        }
        
        if(!this.projectManagers.isEmpty())
        {
            for(projectManager pm : this.projectManagers)
            {
                if(pm.getEmail().equals(email) && pm.getPassword().equals(password))
                {
                    this.PMSession = new projectManager();
                    this.PMSession = pm;
                    this.currentUserRole = 3;
                    this.activeSession = true;
                    this.activeId = pm.getId();
                    return 3;
                }
            }
        }
        
        if(!this.admins.isEmpty())
        {
            for(admin ad : this.admins)
            {
                if(ad.getEmail().equals(email) && ad.getPassword().equals(password))
                {
                    this.adSession = new admin();
                    this.adSession = ad;
                    this.currentUserRole = 4;
                    this.activeSession = true;
                    this.activeId = ad.getId();
                    return 4;
                }
            }
        }
        return 0;
    }
    
    public void logOut()
    {
        this.activeSession = false;
        if(this.currentUserRole == 1)
        {
            this.empSession.setExitTime();
        }
        this.endSession();
    }
    
    public void endSession()
    {
        admin masterAdmin = new admin();
        masterAdmin.commit(this.admins);
        
        projectManager masterPM = new projectManager();
        masterPM.commit(this.projectManagers);
        
        teamLeader masterTL = new teamLeader();
        masterTL.commit(this.teamLeaders);
        
        employee masterEmployee = new employee();
        masterEmployee.commit(this.employees);
        
        project masterProject = new project();
        masterProject.commitToFile(this.projects);   
    }
    
    public String[] getInfo()
    {
        String[] info = new String[7];
        if(this.currentUserRole == 1)
        {
            info[0] = this.empSession.getFirstName();
            info[1] = this.empSession.getLastName();
            info[2] = this.empSession.getEmail();
            info[3] = this.empSession.getPassword();
            info[4] = this.empSession.getGender();
            info[5] = this.empSession.getphoneNumber();
            info[6] = "Employee";
            return info;
        }
        if(this.currentUserRole == 2)
        {
            info[0] = this.TLSession.getFirstName();
            info[1] = this.TLSession.getLastName();
            info[2] = this.TLSession.getEmail();
            info[3] = this.TLSession.getPassword();
            info[4] = this.TLSession.getGender();
            info[5] = this.TLSession.getphoneNumber();
            info[6] = "Team Leader";
            return info;
        }
        if(this.currentUserRole == 3)
        {
            info[0] = this.PMSession.getFirstName();
            info[1] = this.PMSession.getLastName();
            info[2] = this.PMSession.getEmail();
            info[3] = this.PMSession.getPassword();
            info[4] = this.PMSession.getGender();
            info[5] = this.PMSession.getphoneNumber();
            info[6] = "Project Manager";
            return info;
        }
        if(this.currentUserRole == 4)
        {
            info[0] = this.adSession.getFirstName();
            info[1] = this.adSession.getLastName();
            info[2] = this.adSession.getEmail();
            info[3] = this.adSession.getPassword();
            info[4] = this.adSession.getGender();
            info[5] = this.adSession.getphoneNumber();
            info[6] = "Admin";
            return info;
        }
        return info;
    }
    
    public project getProjectById(int id)
    {
        project master = new project();
        return master.getProjectById(this.projects, id);
    }
    
    public ArrayList<project> getAllProjects()
    {
        return this.projects;
    }

    public ArrayList<task> getAllTasks()
    {
        ArrayList<task> allTasks = new ArrayList<>();
        for(project p : this.projects)
        {
            ArrayList<task> all = new ArrayList<>();
            all = p.getTasks();
            if(!all.isEmpty())
            {
                for(task t : all)
                {
                    allTasks.add(t);
                }
            }
        }
        return allTasks;
    }
    
    public boolean assignTask(int taskId, int empId)
    {
        employee masterEMP = new employee();
        employee coder = masterEMP.search(employees, empId);
        task masterTask = new task();
        task asTask = masterTask.search(this.getAllTasks(), taskId);
        if(asTask.getId() != 0)
        {
            if(coder.addNewTask(asTask))
            {
                coder.addNoti(empId, this.activeId, "New task was assigned!");
                return true;
            }
        }
        return false;// if return false "task is already added"
    }
    
    public ArrayList<task> getAllFinishedTasks()
    {
        ArrayList<task> allFin = new ArrayList<>();
        for(project p :this.projects)
        {
            ArrayList<task> finP = new ArrayList<>();
            finP = p.getFinishedTasks();
            if(!finP.isEmpty())
            {
                for(task t:finP)
                {allFin.add(t);}
            }//end of if
        }//end of loop
        return allFin;
    }//end of function
    
    public void makeReport(String report, int empId, int tlId)
    {
        //addNoti(int toId, int fromId, String message)
        report newReport = new report(report, empId, tlId, this.projectManagers.get(0).getId()/*this.PMSession.getId()*/);
        teamLeader masterTL = new teamLeader();
        teamLeader leader = masterTL.search(tlId, this.teamLeaders);
        leader.addReport(newReport);
        this.PMSession.addReport(newReport);
        leader.addNoti(tlId,this.activeId,"You received a report!");
        masterTL.commit(teamLeaders);
    }
    
    
    public ArrayList<notification> getNotifications()
    {
        ArrayList<notification> all = new ArrayList<>();
        if(this.currentUserRole == 1)
        {
            all = this.empSession.getNotifications();
            this.empSession.freeNot();
            this.empSession.commit(this.employees);
        }
        else if(this.currentUserRole == 2)
        {
            all = this.TLSession.getNotifications();
            this.TLSession.freeNot();
            this.TLSession.commit(this.teamLeaders);
        }
        else if(this.currentUserRole == 3)
        {
            all = this.PMSession.getNotifications();
            this.PMSession.freeNot();
            this.PMSession.commit(this.projectManagers);
        }
        else if(this.currentUserRole == 4)
        {
            all = this.adSession.getNotifications();
            this.adSession.freeNot();
            this.adSession.commit(this.admins);
        }
        return all;
    }
    
    public float getProjectProgress(int id)
    {
        project masterProject = new project();
        return masterProject.SearchProject(this.projects, id).getProgress();
    }
    
    public employee getEmployeeById(int id)
    {
        employee master = new employee();
        return master.search(employees, id);   
    }
    
    public report getReportById(int id)
    {
        ArrayList<report> all = new ArrayList<>();
        all = this.getAllReport();
        if(!all.isEmpty())
        {
            for(report r : all)
            {
                if(r.getId() == id)
                {
                    return r;
                }//end of if
            }//end of for
        }//end of if
        return new report();
    }//end of function
    
    public ArrayList<report> getAllReport()
    {
        ArrayList<report> allReports = new ArrayList<>();
        if(!this.teamLeaders.isEmpty())
        {
            for(teamLeader tl : this.teamLeaders)
            {
                ArrayList<report> tlReports = new ArrayList<>();
                tlReports = tl.getReports();
                if(!tlReports.isEmpty())
                {
                    for(report r : tlReports)
                    {
                        allReports.add(r);
                    }//end of for
                }//end of if 
            }//end of for
        }//end of if
        return allReports;
    }//end of function
    public teamLeader getTeamLeaderById(int id)
    {
        teamLeader masterTL = new teamLeader();
        return masterTL.search(id, this.teamLeaders);
    }
    
    public admin getAdminById(int id)
    {
        admin master = new admin();
        return master.search(this.admins, id);
    }
    
    public projectManager getProjectManagerById(int id)
    {
        projectManager master = new projectManager();
        return master.search(id, this.projectManagers);
    }
    
    public ArrayList<vacation> getAllVacations()
    {
        ArrayList<vacation> allVacs = new ArrayList<>();
        for(employee e : this.employees)
        {
            ArrayList<vacation> vacs = new ArrayList<>();
            vacs = e.getAllVacations();
            if(!vacs.isEmpty())
            {
                for(vacation v:vacs)
                {
                    allVacs.add(v);
                }
            }//end of 
        }//end of for
        return allVacs;
    }
    
    public vacation getVacationById(int id)
    {
        ArrayList<vacation> all = new ArrayList<>();
        all = this.getAllVacations();
        for(vacation v : all)
        {
            if(v.getId() == id)return v;
        }
        return new vacation();
    }
    
    public ArrayList<vacation> getPendingVacations(int id)
    {
        ArrayList<vacation> all = new ArrayList<>();
        all = this.getAllVacations();
        ArrayList<vacation> Pvacs = new ArrayList<>();
        for(vacation v : all)
        {
            if(v.getStatus())Pvacs.add(v);
        }
        return Pvacs;
    }
    public String getNameById(int id)
    {
        employee masterEmp = new employee();
        employee emp = new employee();
        emp = masterEmp.search(employees, id);
        if(emp.getId()!= 0)return emp.getFirstName();
        
        teamLeader masterTl = new teamLeader();
        teamLeader tl = new teamLeader();
        tl = masterTl.search(id, teamLeaders);
        if(tl.getId() != 0)return tl.getFirstName();
        
        projectManager masterPM = new projectManager();
        projectManager pm = new projectManager();
        pm = masterPM.search(id, projectManagers);
        if(pm.getId()!=0)return pm.getFirstName();
        
        admin masterAd = new admin();
        admin ad = new admin();
        ad = masterAd.search(admins, id);
        if(ad.getId()!= 0)return ad.getFirstName();
        
        return "";
    }
}//end of class
