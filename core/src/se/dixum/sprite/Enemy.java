package se.dixum.sprite;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import se.dixum.Position;


/**
 * Created by andreasbrommund on 15-12-14.
 */
public class Enemy {

    private float base;
    private float height;

    private Position pos;
    private float angle;

    public Enemy(float x, float y, float angle) {
        this.pos = new Position(x, y);
        base = 24;
        this.angle = angle;
        height = 38;


    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

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
}