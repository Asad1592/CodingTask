import Model.*;
import Utils.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ConferenceManagement {

    public static void main(String[] args) {

        List<Talk> talks = new ArrayList<>();
        Seminar conf;

        System.out.println("***************WELCOME TO CONFERENCE MANAGEMENT SYSTEM**********************************");
        System.out.println("");
        System.out.println("");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the subject matter of the seminar");
        String theme = sc.nextLine();
        conf = new Seminar(theme);

        try {
            talks = CreateTalk();
            System.out.println("List of talks");
            conf.setTracks(CreateTrack(CreateSession(talks)));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ShowConference(conf);
    }

    public static List<Talk> CreateTalk() throws Exception{

        List<Talk> talks = new ArrayList<Talk>();
        String subject="";
        int time=0;
        System.out.println("Please enter the talks and press q(quit) to stop (-: ");
        System.out.println("\n");
        Scanner sc = new Scanner(System.in);
        while(!subject.equalsIgnoreCase("q"))
        {
            System.out.println("Enter the subject:");
            System.out.print(">");
            subject = sc.nextLine();
            if(Validate.ContainsDigit(subject) == true || subject.isEmpty())
                throw new Exception("The subject should not contains a digit or should not be empty");

            if(subject.equalsIgnoreCase("q") == true)
                break;

            System.out.println("Enter the time:");
            try {
                time = sc.nextInt();
                if(Validate.CheckLigthningFive(time)!=true)
                    throw new Exception("The time should be in 5 lightning");

                talks.add(new Talk(subject, time));
                sc.nextLine();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.out.println("Error you have to start again");
            }
        }

        return talks;
    }

    public static List<Session> CreateSession(List<Talk> list)
    {

        List<Session> sessions = new ArrayList<>();
        while (list.size()>=1){
            Session session = new Session(SessionType.MORNING);
            list = session.AddTalks(list);
            sessions.add(session);
            if(list == null || list.size()<=0)
                break;
            Session session1 = new Session(SessionType.AFTERNOON);
            list = session1.AddTalks(list);
            sessions.add(session1);
            if(list == null || list.size()<=0)
                break;
        }
        return  sessions;
    }

    public static List<Track> CreateTrack(List<Session> list){
        List<Track>tracks = new ArrayList<>();
        List<Session> morningSession = new ArrayList<>();
        List<Session> afternoonSession = new ArrayList<>();
        //We separate into two categories morning and afternoon
        for(int i = 0; i<list.size();i++){
            if(list.get(i).getType() == SessionType.MORNING){
                morningSession.add(list.get(i));
            }else {
                afternoonSession.add(list.get(i));
            }
        }
        // then we add morning session
        for (Session s: morningSession){
            try {
                Track t = new Track();
                t.setMorningSession(s);
                tracks.add(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //the number of track was created by morning session, so I go through that list of track and add afternoon session
        for(int j= 0; j<afternoonSession.size();j++){
            try {
                tracks.get(j).setAfternoonSession(afternoonSession.get(j));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tracks;
    }

    public static void ShowConference(Seminar seminar)
    {

        String[] day = {"AM", "PM"};
        for(int i = 0; i< seminar.getTracks().size(); i++)
        {
            int hour=9;
            int minute=0;
            System.out.println("Track "+ (i+1));
            System.out.println();

            for(Talk t: seminar.getTracks().get(i).getMorningSession().getTalks())
            {
                System.out.print(">");
                System.out.print(String.format("%2d",hour));
                System.out.print(":");
                System.out.print(String.format("%2d",minute));
                System.out.print( " " + day[0] +" ");
                System.out.println(t.getSubject() + " "+t.getTime()+ " min");
                minute+=t.getTime();
                if(minute>=60){
                    hour+=1;
                    minute-=60;
                }
            }
            System.out.println(">12:00PM  Lunch");
            hour=1;
            minute=0;
            for(Talk t: seminar.getTracks().get(i).getAfternoonSession().getTalks())
            {
                System.out.print(">");
                System.out.print(String.format("%2d",hour));
                System.out.print(":");
                System.out.print(String.format("%2d",minute));
                System.out.print(" "+day[1]+" ");
                System.out.println(t.getSubject()+ " "+t.getTime()+ " min");
                minute+=t.getTime();
                if(minute>=60){
                    hour+=1;
                    minute-=60;
                }
            }
            System.out.print(">");
            System.out.print(String.format("%2d",hour));
            System.out.print(":");
            System.out.print(String.format("%2d",minute));
            System.out.println("PM Networking Event");


        }
    }

}
