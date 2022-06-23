import Model.Session;
import Model.Talk;
import Model.Track;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class SeminarManagementTest {

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ConferenceManagement.main(args);


    }

    /**
     * Test of CreateTalk method, of class ConferenceManagement.
     */
    @Test
    public void testCreateTalk() {
        System.out.println("CreateTalk");
        String title = "";
        int time = 23;

        assertThrowsExactly(Exception.class, ()->{
            new Talk(title,time);
        });



    }

    @Test
    void testCreateSession() {
        List<Talk> talks = new ArrayList<>();
        try {
            talks.add(new Talk("Ruby Rails", 45));
            talks.add(new Talk("OPP", 55));
            talks.add(new Talk("C programming", 35));
            talks.add(new Talk("Network security", 65));
            talks.add(new Talk("Network systems", 65));
            talks.add(new Talk("Embedded Systems",60));
            List<Session> sessions = ConferenceManagement.CreateSession(talks);
            assertEquals(2,sessions.size());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @Test
    void testcreateTrack() {
        try {
            List<Talk> talks = new ArrayList<>();
            talks.add(new Talk("Ruby Rails", 45));
            talks.add(new Talk("OPP", 55));
            talks.add(new Talk("C programming", 35));
            talks.add(new Talk("Network security", 65));
            talks.add(new Talk("Network systems", 65));
            talks.add(new Talk("Embedded Systems",60));
            List<Track> tracks = ConferenceManagement.CreateTrack(ConferenceManagement.CreateSession(talks));
            int n=tracks.size();
            assertEquals(1, n);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
