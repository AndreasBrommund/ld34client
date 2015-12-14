package se.dixum.sprite;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.graphics.Color;
import se.dixum.Position;

/**
 * Created by andreasbrommund on 15-12-14.
 */
public class Particle{
    private Position pos;
    private float vx;
    private float vy;

    private Color color;

    public Particle(float x, float y, float vx, float vy){
        pos = new Position(x,y);

        this.vx = vx;
        this.vy = vy;

        int i = (int)(Math.random()*3);

        switch (i){
            case 0:
                color = Color.YELLOW;
                break;
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.ORANGE;
                break;
        }
    }

    public void update(){
        pos.setX(pos.getX()+vx);
        pos.setY(pos.getY()+vy);

    }

    public void draw(ShapeRenderer shapeRenderer){

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.identity();
        shapeRenderer.translate(pos.getX(), pos.getY(), 0);
        shapeRenderer.circle(0,0,0.7f);
        shapeRenderer.end();

    }
}