import Model.SessionType;
import Model.Track;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrackTest {
    private Track track;

    @BeforeEach
    public  void CreateInstance(){
        track = new Track();
        //Here we should sort the list of talks
    }

    @Test
    public void ShouldHaveTwoTrack(){
        assertEquals(true, (track.getMorningSession().getType() == SessionType.MORNING && track.getAfternoonSession().getType() == SessionType.AFTERNOON));
    }

    // the morning session should begin at 9 Am and should finish 12pm, that means it is 180 min
    @Test
    public void CheckHours(){
        int sumTime=track.getMorningSession().SumTime();

        assertFalse(180== sumTime);
    }


    @Test
    public void CheckHourNetworkingEvent(){
        int sumTime= track.getAfternoonSession().SumTime();

        assertFalse( sumTime<=240 && 180<= sumTime);
    }
}
