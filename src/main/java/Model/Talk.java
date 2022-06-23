package Model;

import Utils.Validate;

public class Talk {
    private String subject;
    private int time;

    public Talk(String _title, int _time){
        this.subject = _title;
        this.time = _time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) throws Exception {
        if(Validate.ContainsDigit(subject)!=true)
            throw new Exception("The subject should not contains a digit");
        this.subject = subject;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) throws Exception {
        if(Validate.CheckLigthningFive(time)!=true)
            throw new Exception("The subject should not contains a digit");
        this.time = time;
    }

}
