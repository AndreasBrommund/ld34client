package se.dixum;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import se.dixum.connection.SocketConnection;
import se.dixum.protocol.*;

import java.io.IOException;

public class Game extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;
    private SocketConnection connection;
    private Player player;

	@Override
	public void create () {
        shapeRenderer = new ShapeRenderer();
        connection = new SocketConnection("h104n37-far-a13.ias.bredband.telia.com",7978);

        //Inti here
        player = new Player(0,0);


	}

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

	@Override
	public void render () {
        clearScreen();
        updateFromServer();
        draw();
        update();
    }

    private void draw() {
        player.draw(shapeRenderer);
    }

    public void update(){
        player.update();
    }

    public void updateFromServer(){
        PositionProtocol positionProtocol = null;
        try{
            positionProtocol = connection.readPos();
            connection.sendSocket("Hej");
        }catch(IOException e){
            System.err.println("IO err: "+e.getMessage());
        }
        
        player.updateFromServer(positionProtocol);
    }
}
