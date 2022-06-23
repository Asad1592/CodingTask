package Utils;

import Model.Talk;
import Model.Track;

public class Validate {
    public static boolean ContainsDigit(String input)
    {
        for (int i=0; i<input.length(); i++){
            if(Character.isDigit(input.charAt(i)) == true)
                return true;
        }
        return false;
    }

    public static boolean CheckLigthningFive(int number)
    {
        if (number % 5 == 0)
            return true;

        return false;
    }

    public static int CheckHoursMorning(Track track)
    {
        int sumTime = 0;
        for (Talk t:track.getMorningSession().getTalks())
        {
            sumTime += t.getTime();
        }
        return sumTime;
    }

    public static int CheckHourNetworkingEvent(Track track)
    {
        /*
        *this function allows me to know if the networking events starts exactly at 4 or 5pm
        * */
        int sumTime = 0;
        for (Talk t : track.getAfternoonSession().getTalks())
        {
            sumTime += t.getTime();
        }
        return sumTime;
    }


}
