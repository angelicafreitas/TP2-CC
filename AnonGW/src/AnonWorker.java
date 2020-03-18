import Common.Packet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AnonWorker implements Runnable{
    Socket conClient;
    Socket conServer;


    AnonWorker(Socket conClient, String server, int port) throws IOException {
        this.conClient = conClient;
        this.conServer = new Socket(server,port);
    }

    public void run() {
        try {
            BufferedReader inClient = new BufferedReader(new InputStreamReader(conClient.getInputStream()));
            BufferedReader inServer = new BufferedReader(new InputStreamReader(conServer.getInputStream()));
            PrintWriter outClient = new PrintWriter(conClient.getOutputStream(),true);
            PrintWriter outServer = new PrintWriter(conServer.getOutputStream(),true);

            String req;
            while((req=inClient.readLine())!= null) System.out.println(req);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
