package projectmanagement;

import java.io.Serializable;
import java.util.Date;


public class notification implements Serializable{
    private int toId;
    private int fromId;
    private String message;
    private Date time;

    public notification(){}
    public notification(int toId, int fromId, String message) {
        this.toId = toId;
        this.fromId = fromId;
        this.message = message;
        this.time = new Date();
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }    
}
