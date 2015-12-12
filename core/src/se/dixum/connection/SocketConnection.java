package se.dixum.connection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.utils.GdxRuntimeException;

import java.io.IOException;

/**
 * Created by andreasbrommund on 15-12-12.
 */
public class SocketConnection {

    Socket socket;
public void update(){
    System.out.println("Socket update..");
}
    public SocketConnection(String ip,int port) {
        SocketHints socketHints = new SocketHints();
        try {
            socket = Gdx.net.newClientSocket(Net.Protocol.TCP, ip, port, socketHints);
        } catch (GdxRuntimeException ex) {
            System.err.println("Can't open socket");
            System.exit(1);
        }

            try {
                socket.getOutputStream().write("Hey".getBytes());
                String res = "";
                while (true) {
                    int n = socket.getInputStream().read();
                    System.out.println(n);
                    if (n==0) {break;}
res +=Byte.toString((byte)(n));

                }
                System.out.println(res);

            } catch (IOException e) {
                System.err.println("Err");
            }
    }
}
