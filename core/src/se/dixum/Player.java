package se.dixum;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import javafx.geometry.Pos;
import se.dixum.protocol.PositionProtocol;

/**
 * Created by david on 15-12-12.
 */
public class Player {

    private int base = 30;
    private Position pos;
    private float angle;

    public Player(float x, float y) {
        this.pos = new Position(x, y);
    }

    public void update(){

    }

    public void updateFromServer(PositionProtocol positionProtocol){
        this.pos.setX(positionProtocol.pos_x);
        this.pos.setY(positionProtocol.pos_y);
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.identity();
        shapeRenderer.setColor(1, 1, 1, 1);

        System.out.println("X = "+pos.getX()+ " Y = "+ pos.getY());
        float x0 = pos.getX();
        float y0 = pos.getY();
        float x1 = pos.getX()+base/2;
        float y1 = pos.getY()+(float)(Math.sqrt(Math.pow(base,2)-Math.pow(base/2,2)));
        float x2 = pos.getX()+base;
        float y2 = pos.getY();

        shapeRenderer.triangle(x0,y0,x1,y1,x2,y2);
        shapeRenderer.end();
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos){
        this.pos = pos;
    }

}
