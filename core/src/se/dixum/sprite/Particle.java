package se.dixum.sprite;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by andreasbrommund on 15-12-14.
 */
public class Particle{
    private float x;
    private float y;
    private float vx;
    private float vy;
    private Color color;


    public Particle(float x, float y, float vx, float vy){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;

        color = Color.RED;


    }

    public void update(){
        x += vx;
        y += vy;
    }

    public void draw(ShapeRenderer shapeRenderer){
        System.out.println(x);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.circle(x, y, 0.5f);
        shapeRenderer.end();

    }
}