public class Vector {
    public float x1;
    public float y1;
    public float x2;
    public float y2;

    public Vector(float x1, float y1, float x2, float y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public static float cosTheta(Vector v1, Vector v2)
    {
        float dot = ((v1.x2-v1.x1) * (v2.x2-v2.x1)) + ((v1.y2-v1.y1) * (v2.y2-v2.y1));
        return dot/(magnitude(v1)*magnitude(v2));
    }

    public static float magnitude(Vector v)
    {
        return (float)Math.sqrt(Math.pow(v.x2-v.x1, 2) + Math.pow(v.y2-v.y1, 2));
    }

    public static float[] findIntersect(Vector v1, Vector v2)
    {
        float x1 = v1.x1;
        float y1 = v1.y1;
        float x2 = v1.x2;
        float y2 = v1.y2;

        float x3 = v2.x1;
        float y3 = v2.y1;
        float x4 = v2.x2;
        float y4 = v2.y2;

        float den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (den == 0) {
          return null;
        }

        float t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / den;
        float u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / den;

        if (t > 0 && t < 1 && u > 0 && u < 1) {
            float posx = x1 + t * (x2 - x1);
            float posy = y1 + t * (y2 - y1);
            float[] intersectPoint = {posx, posy};
            return intersectPoint;
        }
        return null;
    }

    public Vector rotate(float theta)
    {
        double thetaRad = ((double)theta / 180) * Math.PI;
        float dx = this.x2-this.x1;
        float dy = this.y2-this.y1;

        float newx = (float)(Math.cos(thetaRad)*dx - Math.sin(thetaRad)*dy);
        float newy = (float)(Math.sin(thetaRad)*dx + Math.cos(thetaRad)*dy);

        return new Vector(this.x1, this.y1, this.x1 + newx, this.y1 + newy);
    }


}
