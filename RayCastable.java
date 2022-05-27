import java.awt.*;

public abstract class RayCastable {
    protected float x1;
    protected float y1;
    protected float x2;
    protected float y2;

    public RayCastable(float x1, float y1, float x2, float y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public abstract void draw(Graphics2D g);

    public float[] checkForIntersect(Vector rayCast)
    {
        float[] intersectPoint = Vector.findIntersect(rayCast, new Vector(this.x1, this.y1, this.x2, this.y2));
        return intersectPoint;
    }

    public Vector getVector()
    {
        return new Vector(x1, y1, x2, y2);
    }
}
