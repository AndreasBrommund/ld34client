package se.dixum.sprite;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import se.dixum.Position;
import se.dixum.protocol.PositionProtocol;

/**
 * Created by andreasbrommund on 15-12-14.
 */
public class Enemy {

    private float base;
    private float height;

    private Position pos;
    private float angle;

    public Enemy(float x, float y) {
        this.pos = new Position(x, y);
        base = 60;
        angle = 0;
        height = (float)(Math.sqrt(Math.pow(base,2)-Math.pow(base/2,2)));


    }

    public void update(){
    }

    public void updateFromServer(PositionProtocol positionProtocol){

    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        System.out.println("X = "+pos.getX()+ " Y = "+ pos.getY());
        float x0 = -base*.5f;
        float y0 = -height*.5f;
        float x1 = 0;
        float y1 = height*.5f;
        float x2 = base*.5f;
        float y2 = -height*.5f;

        shapeRenderer.identity();
        shapeRenderer.translate(pos.getX(), pos.getY(), 0);
        shapeRenderer.rotate(0, 0, 1, -90 + angle);

        shapeRenderer.triangle(x0, y0, x1, y1, x2, y2, Color.RED, Color.YELLOW, Color.RED);

        shapeRenderer.end();
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos){
        this.pos = pos;
    }

    public void setAngle(float angle){
        this.angle = angle;
    }

    public float getAngle(){
        return this.angle;
    }



}