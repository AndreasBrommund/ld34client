package se.dixum;

/**
 * Created by david on 15-12-12.
 */
public class Position {
    float x;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    float y;

    public Position(float x, float y){
        this.x = x;
        this.y = y;
    }

}
