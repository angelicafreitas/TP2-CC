package Common;

public class Packet {
    String response;
    String source;
    String destination;

    public Packet(String response,String source, String destination){
        this.response= response;
        this.source=source;
        this.destination=destination;
    }
}
