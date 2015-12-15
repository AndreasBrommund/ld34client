package se.dixum.sprite;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import se.dixum.Game;
import se.dixum.Position;
import se.dixum.protocol.EntityPackage;


/**
 * Created by david on 15-12-12.
 */
public class Player {

    private float base;
    private float height;

    private Position pos;
    private float angle;

    private boolean alive;

    private Game game;

    private long respawn;

    public Player(float x, float y, float angle,Game game) {
        this.pos = new Position(x, y);
        base = 24;
        this.angle = angle;
        height = 38;

        this.game = game;

        alive = true;

        respawn = 0;
    }


    public boolean updateFromServer(EntityPackage entityPackage){
        this.pos.setX(entityPackage.position.pos_x);
        this.pos.setY(entityPackage.position.pos_y);
        this.setAngle(entityPackage.angle);
        alive = entityPackage.Alive;

        if (!alive){
            game.spawnExplosion(pos.getX(),pos.getY());
            if (respawn == 0){
                respawn = System.currentTimeMillis() + 2000;
            }
            if(System.currentTimeMillis() >= respawn){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public void draw(ShapeRenderer shapeRenderer) {
        if (alive) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

            float x0 = -base * .5f;
            float y0 = -height * .5f;
            float x1 = 0;
            float y1 = height * .5f;
            float x2 = base * .5f;
            float y2 = -height * .5f;

            shapeRenderer.identity();
            shapeRenderer.translate(pos.getX(), pos.getY(), 0);
            shapeRenderer.rotate(0, 0, 1, -90 + angle);

            shapeRenderer.triangle(x0, y0, x1, y1, x2, y2, Color.TAN, Color.GREEN, Color.TAN);

            shapeRenderer.end();
        }
    }

    public void setAngle(float angle){
        this.angle = angle;
    }

}
