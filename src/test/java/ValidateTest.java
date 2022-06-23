import Model.Track;
import Utils.Validate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateTest {
        private Track track;

        @BeforeEach
        public void CreateInstance()
        {
                track = new Track();
        }

        @Test
        public void ContainsDigitTest()
        {
                String test = "jfglj44s1gg";

                assertTrue(Validate.ContainsDigit(test));
        }

        @Test
        public void ContainsDigitTest2()
        {
                String test = "eifufsdjfjsd";

                assertFalse(Validate.ContainsDigit(test));
        }

        @Test
        public void CheckLigthningFiveTest()
        {
                assertTrue(Validate.CheckLigthningFive(25));
        }


        @Test
        public void CheckLigthningFiveTest2()
        {
                assertFalse(Validate.CheckLigthningFive(13));
        }

        @Test
        public void CheckHoursMorningTest()
        {
                assertEquals(0, Validate.CheckHoursMorning(track));
        }

        @Test
        public void CheckHourNetworkingEventTest()
        {
                int somme = Validate.CheckHourNetworkingEvent(track);
                assertFalse((somme <= 240 && 180 <= somme));
        }
}
