package se.dixum.sprite;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import se.dixum.Position;

/**
 * Created by andreasbrommund on 15-12-14.
 */
public class Bullet {
    private float width;
    private float height;

    private Position pos;
    private float angle;

    public Bullet(float x, float y, float angle) {
        this.pos = new Position(x, y);
        width = 2;
        this.angle = angle;
        height = 5;


    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.identity();
        shapeRenderer.translate(pos.getX(), pos.getY(), 0);
        shapeRenderer.rotate(0, 0, 1, -90 + angle);

        shapeRenderer.setColor(Color.YELLOW);

        shapeRenderer.rect(-width/2,-height/2,width,height);
        shapeRenderer.end();
    }
}
