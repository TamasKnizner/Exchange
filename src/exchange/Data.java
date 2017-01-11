package exchange;

public class Data {

    private int time;
    private double rate;

    public Data() {

    }

    public Data(int time, double rate) {
        this.time = time;
        this.rate = rate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Rate at " + time + " is " + rate;
    }

}
