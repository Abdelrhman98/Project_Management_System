package projectmanagement;

import java.io.Serializable;
import java.util.ArrayList;

public class report implements Serializable{
    private String Report;
    private int empId;
    private int teamLeaderId;
    private int projectManagerId;
    private int id;
    
    public int getId() {
        return id;
    }
    public report(){}
    public void setId() {
        fileManager f = new fileManager();
        int generateId = (((int)f.read("reportId.bin"))+1);
        f.write("reportId.bin", generateId);
        this.id = generateId;
    }

    public report(String Report, int empId, int teamLeaderId, int projectManagerId) {
        this.Report = Report;
        this.empId = empId;
        this.teamLeaderId = teamLeaderId;
        this.projectManagerId = projectManagerId;
        this.setId();
    }
    
    public String getReport() {
        return Report;
    }

    public void setReport(String Report) {
        this.Report = Report;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(int teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    public int getProjectManagerId() {
        return projectManagerId;
    }

    public void setProjectManagerId(int projectManagerId) {
        this.projectManagerId = projectManagerId;
    }
    
    public report search(int id, ArrayList<report> all)
    {
        for(report re : all)
        {
            if(re.getId() == id)
            {
                return re;
            }
        }
        return new report();
    }
}//end of class 
