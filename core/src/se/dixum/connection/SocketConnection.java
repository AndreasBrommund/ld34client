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

    private Socket socket;

    public void update() {
       // System.out.println("Socket update..");
    }

    public SocketConnection(String ip, int port) {
        SocketHints socketHints = new SocketHints();
        try {
            socket = Gdx.net.newClientSocket(Net.Protocol.TCP, ip, port, socketHints);
        } catch (GdxRuntimeException ex) {
            System.err.println("Can't open socket");
            System.exit(1);
        }
    }


    public void sendSocket(String content) throws IOException {
        socket.getOutputStream().write(content.getBytes());
    }

    public String readSocket() throws IOException {

        String res = "";

        while (true) {
            int n = socket.getInputStream().read();

            if (n == (int)'\n') {
                break;
            }
            res += (char)n;
        }
        return res;
   }

}
