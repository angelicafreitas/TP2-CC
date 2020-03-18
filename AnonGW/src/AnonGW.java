import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class AnonGW {
    public static int port;
    public static ArrayList<String> peers;

    AnonGW(){
        this.peers = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        try{
            if(args.length >= 7){
                if(args[1].equals("target-server") && args[3].equals("port") && args[5].equals("overlay-peers")){
                    //not necessary for phase 1
                    peers = new ArrayList<>();
                    for(int i=6;i<args.length;i++){
                        peers.add(args[i]);
                    }
                    port=Integer.parseInt(args[4]);
                    ServerSocket ssocket = new ServerSocket(port);

                    while(true){
                        Socket s = ssocket.accept();
                        AnonWorker a = new AnonWorker(s,args[2], port);
                        Thread t = new Thread(a);
                        t.start();
                    }
                }
            }
            else{
                System.out.println("Input inválido");
            }
        }catch(Exception e){
            e.getMessage();
        }
    }

}
