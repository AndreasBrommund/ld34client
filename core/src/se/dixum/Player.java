package se.dixum;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by david on 15-12-12.
 */
public class Player {

    private int base = 30;
    private Position pos;
    private float angle;

    public Player(float x, float y) {
        this.pos = new Position(x + (base >> 1), y);

    }

    public void update(){

    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.identity();
        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.triangle(getPos().getX() - (base >> 1), getPos().getY(), base >> 1, getPos().getY() + base, getPos().getX() + (base >> 1), getPos().getY());
        shapeRenderer.end();
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos){
        this.pos = pos;
    }

}
