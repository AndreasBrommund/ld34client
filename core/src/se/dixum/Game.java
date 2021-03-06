package se.dixum;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import se.dixum.connection.SocketConnection;
import se.dixum.protocol.*;
import se.dixum.sprite.Bullet;
import se.dixum.sprite.Enemy;
import se.dixum.sprite.Explosion;
import se.dixum.sprite.Player;

import java.io.IOException;
import java.util.ArrayList;

public class Game extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;
    private SocketConnection connection;
    private Player player;
    private ArrayList<Enemy> enemy;
    private ArrayList<Bullet> bullet;
    private ArrayList<Explosion> explosions;

	@Override
	public void create () {
        shapeRenderer = new ShapeRenderer();
        connection = new SocketConnection("h104n37-far-a13.ias.bredband.telia.com",7978);
        //connection = new SocketConnection("me",7978);

        //Inti here
        player = new Player(0,0,0,this);
        enemy = new ArrayList<Enemy>();
        bullet = new ArrayList<Bullet>();
        explosions = new ArrayList<Explosion>();
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

        for (Enemy e:enemy) {
            e.draw(shapeRenderer);
        }

        for (Explosion e:explosions) {
            e.draw(shapeRenderer);
        }

        for (Bullet b:bullet){
            b.draw(shapeRenderer);
        }

        player.draw(shapeRenderer);

    }

    public void update(){

        for (Explosion e:explosions) {
            e.update();
        }

    }

    public void updateFromServer(){
        UpdatePackage updatePackage = null;

        byte[] send = new byte[1];
        send[0] = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            send[0] = 0x01;
        }else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            send[0] = 0x02;
        }

        try{
            updatePackage = connection.readUpdate();
            connection.sendSocket(send);
        }catch(IOException e){
            System.err.println("IO err: "+e.getMessage());
        }

        if (player.updateFromServer(updatePackage.player)){
            send[0] = 3;
            try {
                connection.sendSocket(send);
            }catch (IOException ex){

            }
        }

        enemy = new ArrayList<Enemy>();

        for (EntityPackage ep : updatePackage.enemies){
            enemy.add(new Enemy(ep.position.pos_x,ep.position.pos_y,ep.angle,ep.Alive,this));
        }

        bullet = new ArrayList<Bullet>();


        for (EntityPackage ep : updatePackage.bullets){
            bullet.add(new Bullet(ep.position.pos_x,ep.position.pos_y,ep.angle));
        }
    }

    public void spawnExplosion(float x,float y){
       // explosions.add(new Explosion(x,y));
    }
}
