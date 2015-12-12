package se.dixum;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by david on 15-12-12.
 */
public class Player {
    int base =30;
    public Position getPos() {
        return pos;
    }

    Position pos;
    float angle;

    public Player(float x, float y){
        this.pos = new Position(x+(base>>1), y);

    }
    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.identity();
        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.triangle(getPos().getX()-(base>>1),getPos().getY(), base>>1, getPos().getY()+base,getPos().getX() + (base>>1),getPos().getY());
        shapeRenderer.end();
    }

}
