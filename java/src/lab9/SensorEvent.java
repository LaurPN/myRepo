package lab9;

import java.util.Date;

public class SensorEvent {
    private int sensorId;
    private int type;
    private Date time;

    public SensorEvent(int sensorId, int type, Date time) {
        this.sensorId = sensorId;
        this.type = type;
        this.time = time;
    }

    public int getSensorId() {
        return sensorId;
    }

    public int getType() {
        return type;
    }

    public Date getTime() {
        return time;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
