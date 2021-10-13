package models;

public class Values {

    private String ip;
    private int port;
    private int time;
    private int serial;
    private int formID=1;

    public Values(String ip, int port, int time){
        this.ip = ip;
        this.port = port;
        this.time = time;
    }

    public Values(){}

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public int getTime() {
        return time;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public int getFormID() {
        return formID;
    }

    public int getNextFormID(){
        return formID++;
    }

}
