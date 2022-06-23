package Model;

import Utils.Validate;

import java.util.ArrayList;
import java.util.List;

public class Seminar {
    private String topic;
    private List<Track> tracks;

    public Seminar(String topic) {
        this.topic = topic;
        this.tracks = new ArrayList<>();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) throws Exception{
        for(Track tr: tracks)
        {
            if(Validate.CheckHoursMorning(tr) != 180){
                throw new Exception(" By 12 noon morning sessions must be finished, for lunch " + Validate.CheckHoursMorning(tr));
            }
            int time = Validate.CheckHourNetworkingEvent(tr);
            if(time > 240 || 180 > time){
                throw new Exception("The networking event can start no earlier than 4:00 and no later than 5:00 pm "+ Validate.CheckHourNetworkingEvent(tr));
            }
        }
        this.tracks = tracks;
    }
}
