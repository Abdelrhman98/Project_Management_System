package projectmanagement;

import java.util.*;
import java.text.*;
import java.util.regex.Pattern;

public class ProjectManagement {    
    public static void main(String []args) throws ParseException {
        
        LoginForm LF = new LoginForm();
        LF.setVisible(true);
        
        container con = new container();
        char []s =  new char[9];
        s[0] = '1';
        s[1] = '2';
        s[2] = '3';
        s[3] = '4';
        s[4] = '5';
        s[5] = '6';
        s[6] = '7';
        s[7] = '8';
        s[8] = 'e';
        System.out.print(con.login("shaker@gmail.com",s));
        
        //System.out.print(con.login("shaker@gmail.com", ));
        /*
        char []s =  new char[9];
        s[0] = '1';
        s[1] = '2';
        s[2] = '3';
        s[3] = '4';
        s[4] = '5';
        s[5] = '6';
        s[6] = '7';
        s[7] = '8';
        s[8] = 'e';
        con.login("shaker@gmail.com",s);
        //(int id, String fname,String lname,String email,String password,String phone,String gender,String address, int role)
        ArrayList<String> sss = con.updateUser(con.empSession.getId(), "abdo", "LOLO", con.empSession.getEmail(), "12345678e", "01224466188", "", "", 1);
        if(sss.isEmpty())
        {
            System.out.print(con.empSession.getLastName());
        }
        else
        {
            System.out.print(sss.size());
        }*/
        //con.updateUser(con, null, null, null, null, null, null, null, 1);
        //System.out.print(con.projectManagers.get(0).getAllReports().size());
        //(int id, String fname,String lname,String email,String password,String phone,String gender,String address, int role);
        //employee x = con.employees.get(0);
        //System.out.print(x.getFirstName());
        /*ArrayList<String> y = con.updateUser(x.getId(), "ali", "hamed", "ali@gmail.com", "12345678e", "01113348877", "", "", 1);
        if(y.size()>0)
        {
            System.out.print(x.getFirstName());
        }
        else 
        {
            for(String s: y)
                System.out.println(s);
        }*/
/*
        ArrayList<task> tasks = new ArrayList<>();
        tasks = con.getAllTasks() ;
        task x = new task();
        x = con.getTaskById(4);
        System.out.print(x.getTaskDesc());*/
        /*System.out.print(con.teamLeaders.get(0).getId());
        //tl 16
        //pm 17
        char []s =  new char[9];
        s[0] = '1';
        s[1] = '2';
        s[2] = '3';
        s[3] = '4';
        s[4] = '5';
        s[5] = '6';
        s[6] = '7';
        s[7] = '8';
        s[8] = 'e';
        con.login("abdo@gmail.com",s);
        con.makeReport("test ay 7aga", con.employees.get(0).getId(), 16);*/
        //con.logOut();
        /*
        
        //String Report, int empId, int teamLeaderId, int projectManagerId
        report x = new report("any thing",1,2,con.PMSession.getId());
        System.out.println(con.PMSession.allReports.size());
        */
        /*ArrayList<task> all = new ArrayList<>();
        employee x = new employee();
        //String name, int pID,employee coder, String desc,Date deadLine
        task x1 = new task("first task",2,x,"any thing",new Date() );
        all.add(x1);
        task x2 = new task("second task",2,x,"any thing",new Date() );
        all.add(x2);
        task x3 = new task("third task",2,x,"any thing",new Date() );
        all.add(x3);
        task x4 = new task("fourth task",2,x,"any thing",new Date() );
        all.add(x4);
        all.get(0).setStatus(true);
        all.get(2).setStatus(true);
        project p = new project("firstProject", new Date(),all);
        ArrayList<project> al = new ArrayList<>();
        al.add(p);
        p.commitToFile(al);*/
        //public project(String ProjectName, Date deadline, ArrayList<task> tasks)
        /*
        ArrayList<project> all = new ArrayList<>();
        project x = new project();
        x.commitToFile(all);
        */
        
          /*ArrayList<employee> all = new ArrayList<>();
          employee x= new employee();
          x.commit(all);*/
        /*container con = new container();
        System.out.println(con.getAllFinishedTasks().size());*/
        
        
        /*ArrayList<teamLeader> all = new ArrayList<>();
          teamLeader x= new teamLeader();
          x.commit(all);
        */
        
        /*
            ArrayList<projectManager> all = new ArrayList<>();
            projectManager x= new projectManager();
            x.commit(all);
        */
        /*ArrayList<admin> all = new ArrayList<>();
          admin x= new admin();
          x.commit(all);*/
        //container c = new container();
        /*
        container c = new container();
        c.addNewTask("TEST", 3, c.getEmployeeById(7), "TEST TEST TEST", "05/05/2020");
        System.out.println(c.getTaskById(c.employees.get(0).getTasks().get(0).getId()).getTaskName());*/
        /*container con = new container();
        con.login("shaker@gmail.com", "12345678e");
        
        //String name, int pID,employee coder, String desc,Date deadLine
        con.makeReport("good work !", con.empSession.getId(), con.teamLeaders.get(0).getId());
        System.out.println();
        con.logOut();*/
        /*
        penaltie x = new penaltie(con.empSession.getId(),"talk at meeting");
        con.empSession.addPenaltie(x);
        con.empSession.addNoti(con.empSession.getId(), 2, "you Have new penaltiy");
        con.logOut();
        */
        
        
        
        
        /*
        container con = new container();
        ArrayList<String> allErr = new ArrayList<>();
        allErr = con.addNewUser("abdo","shaker","shaker@gmail.com","12345678e","01113348877","male","elHaram",1,"");
        if(!allErr.isEmpty())
        {
            for(String err:allErr)
            {
                System.out.println(err);
            }
        }
        allErr = con.addNewUser("kariem","yasser","kariem@gmail.com","12345678e","01226644177","male","fesal",2,"");
        if(!allErr.isEmpty())
        {
            for(String err:allErr)
            {
                System.out.println(err);
            }
        }
        allErr = con.addNewUser("abdelrhman","hashem","abdo@gmail.com","12345678e","01114456654","male","helwan",3,"");
        if(!allErr.isEmpty())
        {
            for(String err:allErr)
            {
                System.out.println(err);
            }
        }
        allErr = con.addNewUser("shrouk","ragab","shrouk@gmail.com","12345678e","01112276453","female","eldoki",4,"");
        if(!allErr.isEmpty())
        {
            for(String err:allErr)
            {
                System.out.println(err);
            }
        }
        
        con.logOut();
        */
        
        //System.out.print(con.empSession.getId());
        //con.addNewUser("second","employee","semp@gmail.com","1234567e","01113348877","male","elHaram",1,"");*/
        /*con.logOut();*/
        //System.out.print(con.employees.size());
        /*
        String email= new String(), password = new String();
        Scanner input = new Scanner(System.in);
        email = input.nextLine();
        password = input.nextLine();
        if(con.login(email, password)>=1)
        {
            int ch = input.nextInt();
            while(ch != 0)
            {
                if(ch == 1)
                {
                    System.out.println(con.empSession.getMyHours());
                }
                else if(ch == 2)
                {
                    con.empSession.requestVacation(new Date());
                }
                else if(ch == 3)
                {
                    ArrayList<penaltie> all = con.empSession.getAllPenalties();
                    if(all.size()>0)
                    {
                        for(penaltie p : all)
                        {
                            System.out.println(p.getId()+ " "+ p.getEmpId() + " " + p.getReason());
                        }
                    }
                    else
                    {
                        System.out.println("no penalties");
                    }
                }
                
                else if(ch == 4)
                {
                    System.out.println(con.empSession.getMyHours());
                }
                else if(ch == 5)
                {
                    
                }
                
                else if(ch == 6)
                {
                    
                }
                ch = input.nextInt();
            }
            con.logOut();
        }
        */
        //System.out.println(con.login("semp@gmail.com","1234567e"));
        //con.empSession.requestVacation(new Date());
        
        //con.endSession();
        //con.logOut();
        //System.out.print(con.empSession.getMyHours());
        //con.logOut();
        /*con.addNewUser("first","employee","emp@gmail.com","1234567e","01113348877","male","elHaram",1,"");
        penaltie pe = new penaltie(con.employees.get(0).getId(),"any thing");
        con.employees.get(0).addPenaltie(pe);
        con.employees.get(0).requestVacation(new Date());
        con.employees.get(0).setEntryTime();*/
        /*con.addNewUser("first","teamLeader","tl@gmail.com","1234567e","01113348877","female","elHaram",2,"");
        con.addNewUser("first","projectManager","pm@gmail.com","1234567e","01113348877","male","elHaram",3,"");
        con.addNewUser("first","Admin","ad@gmail.com","1234567e","01113348877","female","elHaram",4,"");*/
        //con.endSession();
        //con.addNewUser("abdelrhman","solieman","abdelrhman.solieman98@gmail.com","1234567e","01113348877","male","elHaram",1);
        //con.login("abdelrhman.solieman98@gmail.com", "1234567e");
        //penaltie ne = new penaltie(con.empSession.getId(),"any thing");
        //con.empSession.addPenaltie(ne);
        
        //System.out.println(con.empSession.getAllPenalties().size());
        //con.endSession();
        /*String str = con.employees.get(0).getEmail();
        String str_2 = con.employees.get(0).getPassword();
        System.out.print(con.login(str, str_2));*/
        //con.login("abdelrhman.solieman98@gmail.com", "1234567e");
        
//        penaltie ne = new penaltie(con.empSession.getId(),"any thing");/
  //      con.empSession.addPenaltie(ne);
        //System.out.print(con.empSession.getAllPenalties().size());
        //String []str = con.getInfo();
        /*
        info[0] -> first name
        info[1] -> last name
        info[2] -> email
        info[3] -> password
        info[4] -> gender
        info[5] -> phoneNumber
         */
//        container con = new container();
//        ArrayList<String> info = con.getInfo();
        /*
        info.get(0) -> first name
        info.get(1) -> last name
        info.get(2) -> email
        info.get(3) -> password
        info.get(4) -> gender
        info.get(5) -> phoneNumber
         */
        //public boolean addNewTask(String taskName, int projectId, employee coder, String desc, Date deadLine)
        //public void addNewProject(String projectName, Date deadLine)
        /*ArrayList<employee> all = new ArrayList<>();
        employee x = new employee();
        x.commit(all);
        String fname, lname, email, password, phone, gender, address;
        int role;
        Scanner input = new Scanner(System.in);
        fname = input.next();
        lname = input.next();
        email = input.next();
        password = input.next();
        phone = input.next();
        gender = input.next();
        address = input.next();
        role = 1;
        ArrayList<String> err = con.addNewUser("islam", "tarek", "test@gmail.com", "pass12345", "01113348877", "male", "elbhos", 1);
        if(err.isEmpty())
        {
        System.out.println("the new user added");
        }
        else
        {
        for(String e : err)
        {
        System.out.println(e);
        }
        }*/
        //abdelrhman mohamed abdelrhman.soleman98@gmail.com pass12345 01113348877 male elharam
        /*user master = new user();
        ArrayList<user> users = new ArrayList<>();
        user x1 = new user("abdelrhman","solieman","abdelrhman.solieman@gmail.com","12345","01226644175","mail","1212",1,1);
        user x2 = new user("abdelrhman","solieman","abdelrhman.solieman@gmail.com","12345","01226644175","mail","1212",1,2);
        user x3 = new user("abdelrhman","solieman","abdelrhman.solieman@gmail.com","12345","01226644175","mail","1212",1,3);
        user x4 = new user("abdelrhman","solieman","abdelrhman.solieman@gmail.com","12345","01226644175","mail","1212",1,4);
        users.add(x1);
        users.add(x2);
        users.add(x3);
        users.add(x4);
        master.commitToFile(users);*/
        //
        //Date x = new Date();
        //System.out.print(x);
        //container m = new container();
        //System.out.print(m.employees.size());
        /*user master = new user();
        ArrayList<user> users = new ArrayList<>();
        users = master.readFromFile();
        //System.out.print(users.get(0).getEmail());
        ArrayList<employee> emp = new ArrayList<>();
        emp = master.getUsersByRole(users, 1);
        Date now = new Date();
        ArrayList<project> y1 = new ArrayList<>();
        task masterTask = new task();
        ArrayList<task> tasks = new ArrayList<>();
        task t1 = new task(masterTask.generateId(tasks),"firstTask",1,emp.get(0),"ay 7aga",now);
        tasks.add(t1);
        project z1 = new project();
        project x1 = new project(z1.generateId(y1),"firstProject",now,tasks);
        y1.add(x1);
        project u1 = new project(z1.generateId(y1),"secondProject",now,tasks);
        y1.add(u1);
        u1.commitToFile(y1);
        System.out.print(y1.get(0).getName());*/
        //container lol = new container();
        //System.out.print(m.employees.size());
        /*user master = new user();
        ArrayList<user> users = new ArrayList<>();
        users = master.readFromFile();
        //System.out.print(users.get(0).getEmail());
        ArrayList<employee> emp = new ArrayList<>();
        emp = master.getUsersByRole(users, 1);
        Date now = new Date();
        ArrayList<project> y1 = new ArrayList<>();
        task masterTask = new task();
        ArrayList<task> tasks = new ArrayList<>();
        task t1 = new task(masterTask.generateId(tasks),"firstTask",1,emp.get(0),"ay 7aga",now);
        tasks.add(t1);
        project z1 = new project();
        project x1 = new project(z1.generateId(y1),"firstProject",now,tasks);
        y1.add(x1);
        project u1 = new project(z1.generateId(y1),"secondProject",now,tasks);
        y1.add(u1);
        u1.commitToFile(y1);
        System.out.print(y1.get(0).getName());*/
        //container lol = new container();
        
        
       
    }
}
