package Model;

public class Track {
    Session morningSession;
    Session afternoonSession;

    public Track() {
        this.morningSession = new Session(SessionType.MORNING);
        this.afternoonSession = new Session(SessionType.AFTERNOON);
    }

    public Session getMorningSession() {
        return morningSession;
    }

    public Session getAfternoonSession() {
        return afternoonSession;
    }

    public void setMorningSession(Session morningSession) throws Exception {
        if(morningSession.getType() != this.morningSession.getType())
            throw new Exception("The type is different");
        this.morningSession = morningSession;
    }

    public void setAfternoonSession(Session afternoonSession) throws Exception {
        if(morningSession.getType() != this.morningSession.getType())
            throw new Exception("The type is different");
        this.afternoonSession = afternoonSession;
    }
}
