package Model;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private List<Talk> talks;
    private SessionType type;

    public  Session(SessionType _type){
        this.talks = new ArrayList<>();
        this.type = _type;
    }

    public List<Talk> getTalks() {
        return talks;
    }

    public SessionType getType() {
        return type;
    }

    public int SumTime(){
        int sum =0;
        for(Talk t: this.talks){
            sum += t.getTime();
        }
        return sum;
    }


    public List<Talk> AddTalks(List<Talk> tls) {
        int i = 0;
        if (type == SessionType.MORNING) {
            //when it is a morning session
            for (i = 0; i < tls.size(); i++)
            {
                //The morning session should start at 9 and finished at 12pm that is 3 hours -> 180 minutes
                if((this.SumTime() + tls.get(i).getTime()) > 180)
                { //when the sum of time of talks are greater than 180, we should check whether the sum of time of previous talk are
                    //equal to 180
                    for(int k=i;k< tls.size();k++)
                    {
                        if((this.SumTime() + tls.get(k).getTime()) == 180)
                        {
                            this.talks.add(tls.get(k));
                            tls.remove(k);
                        }
                    }
                    break;
                }else{
                    this.talks.add(tls.get(i));
                }
            }
            /*
            if the current index (i) is equal to the size of the list, then the list is empty
            if the current index(i) is equal to the last index, that means it remains a element to the list
             */
            return (i== tls.size() || tls.size()<=0)?null:tls.subList(i-1, tls.size() - 1);
        }

        else {
            i = 0;
            for (i = 0; i < tls.size(); i++) {
                if((this.SumTime() + tls.get(i).getTime()) > 240)
                {
                    for(int k=i;k< tls.size();k++)
                    {
                        if((this.SumTime() + tls.get(k).getTime()) <= 240)
                        {
                            this.talks.add(tls.get(k));
                            tls.remove(k);
                        }
                    }
                    break;
                }else{
                    this.talks.add(tls.get(i));
                }
            }
            return (i== tls.size() || tls.size()<=0)?null:tls.subList(i-1, tls.size() - 1);
        }

    }

}
