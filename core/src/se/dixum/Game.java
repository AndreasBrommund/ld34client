package se.dixum;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import se.dixum.connection.SocketConnection;

public class Game extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    SocketConnection connection;

	@Override
	public void create () {
        shapeRenderer = new ShapeRenderer();
        connection = new SocketConnection("192.168.1.31",7978);
	}

	@Override
	public void render () {
        update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.identity();
        shapeRenderer.setColor(1,1,1,1);
        shapeRenderer.triangle(0,0,100,100,100,0);
		shapeRenderer.end();
	}

    public void update(){

    }
}
