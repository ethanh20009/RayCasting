import java.awt.*;

public class Wall extends RayCastable{

    public Wall(float x1, float y1, float x2, float y2)
    {
        super(x1, y1, x2, y2);

    }

    public void draw(Graphics2D g)
    {
        g.drawLine((int)this.x1, (int)this.y1, (int)this.x2, (int)this.y2);
    }

    


}
