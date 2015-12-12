package se.dixum;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import se.dixum.connection.SocketConnection;

public class Game extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;
    private SocketConnection connection;
    private Player player;

	@Override
	public void create () {
        shapeRenderer = new ShapeRenderer();
        connection = new SocketConnection("192.168.1.31",7978);

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
        draw();
        update();
    }

    private void draw() {
        player.draw(shapeRenderer);
    }

    public void update(){
        player.update();
        connection.update();
    }
}
