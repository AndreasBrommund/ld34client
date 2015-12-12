package se.dixum;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import se.dixum.connection.SocketConnection;

public class Game extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    SocketConnection connection;
    Player player;
	@Override
	public void create () {
        shapeRenderer = new ShapeRenderer();
        player = new Player(0,0);
        connection = new SocketConnection("127.0.0.1",7978);
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

        connection.update();
    }
}
