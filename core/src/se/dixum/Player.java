package se.dixum;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import javafx.geometry.Pos;
import se.dixum.protocol.PositionProtocol;

/**
 * Created by david on 15-12-12.
 */
public class Player {

    private float base = 60;
    private float height;

    private Position pos;
    private float angle;

    public Player(float x, float y) {
        this.pos = new Position(x, y);
        height = (float)(Math.sqrt(Math.pow(base,2)-Math.pow(base/2,2)));
        System.out.println(height);
    }

    public void update(){

    }

    public void updateFromServer(PositionProtocol positionProtocol){
        this.pos.setX(positionProtocol.pos_x);
        this.pos.setY(positionProtocol.pos_y);
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.identity();
        shapeRenderer.setColor(0, 0, 0, 1);

        System.out.println("X = "+pos.getX()+ " Y = "+ pos.getY());
        float x0 = pos.getX()-base*.5f;
        float y0 = pos.getY()-height*.5f;
        float x1 = pos.getX();
        float y1 = pos.getY()+height*.5f;
        float x2 = pos.getX()+base*.5f;
        float y2 = pos.getY()-height*.5f;
        shapeRenderer.triangle(x0,y0,x1,y1,x2,y2);
        shapeRenderer.setColor(1,0,0,1);
        shapeRenderer.point(pos.getX(), pos.getY(), 0);
        shapeRenderer.end();
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos){
        this.pos = pos;
    }

}
