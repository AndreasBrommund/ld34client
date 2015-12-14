package se.dixum.sprite;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

/**
 * Created by andreasbrommund on 15-12-14.
 */
public class Explosion{
    private float x;
    private float y;

    private ArrayList<Particle> particles;

    private boolean explode;

    long endTime;

    public Explosion(float x, float y){
        this.x = x;
        this.y = y;

        particles = new ArrayList<Particle>();

        for (int i = 0; i < 100;i++){
            particles.add(new Particle(x,y, MathUtils.random(-0.5f,0.5f),MathUtils.random(-0.5f, 0.5f)));
        }

        explode = false;
        endTime = System.currentTimeMillis()+1000;
    }

    public void draw(ShapeRenderer shapeRenderer){
        for(Particle p:particles){
            p.draw(shapeRenderer);

        }
    }
    public void update() {
        if (explode) {
            if (System.currentTimeMillis() >= endTime) {
                explode = false;
                particles = new ArrayList<Particle>();
            }

            for (Particle p : particles) {
                p.update();
            }
        }
    }
}
