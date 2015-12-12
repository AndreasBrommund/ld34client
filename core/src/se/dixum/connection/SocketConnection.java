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

    public SocketConnection(String ip,int port){
        SocketHints socketHints = new SocketHints();
        try {
            socket = Gdx.net.newClientSocket(Net.Protocol.TCP, ip, port, socketHints);
        }catch(GdxRuntimeException ex){
            System.err.println("Can't open socket");
        }

        try {
            System.out.print(socket.getInputStream().read());
        } catch (IOException e) {
            System.err.println("Err");
        }

    }
}
