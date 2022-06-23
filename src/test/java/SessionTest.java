import Model.Session;
import Model.SessionType;
import Model.Talk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessionTest {

    private Session afternoonSession;
    private Session morningSession;

    @BeforeEach
    public void CreateInstance() {
        afternoonSession = new Session(SessionType.AFTERNOON);
        morningSession = new Session(SessionType.AFTERNOON);
    }


    @Test
    void sumTime() {
    }

    @Test
    void addTalks() {
        List<Talk> talks = new ArrayList<>();
        assertEquals(null, morningSession.AddTalks(talks));
    }
}
