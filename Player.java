import java.awt.*;

public class Player implements Drawable{
    private float[] pos;
    private boolean upHeld;
    private boolean leftHeld;
    private boolean rightHeld;
    private boolean downHeld;
    private float speed;
    private float viewAngle;
    private boolean lookingLeft;
    private boolean lookingRight;

    public Player()
    {
        this.pos = new float[2];
        this.pos[0] = 100;
        this.pos[1] = 100;
        this.upHeld = false;
        this.leftHeld = false;
        this.rightHeld = false;
        this.downHeld = false;
        this.speed = 2;
        this.viewAngle = 0;
        this.lookingLeft = false;
        this.lookingRight = false;
    }

    public void draw(Graphics2D g)
    {
        g.drawOval((int)this.pos[0]-5, (int)this.pos[1]-5, 10, 10);
    }

    public void move(float x, float y)
    {
        Vector velocityVec = new Vector(0, 0, x, y);
        velocityVec = velocityVec.rotate(this.viewAngle);
        this.pos[0] += velocityVec.x2;
        this.pos[1] += velocityVec.y2;
    }

    public void setPosition(float x, float y)
    {
        this.pos[0] = x;
        this.pos[1] = y;
    }

    public void update()
    {
        float[] velocity = {0, 0};
        if (upHeld) {velocity[1] -= 1;}
        if (downHeld) {velocity[1] += 1;}
        if (leftHeld) {velocity[0] -= 1;}
        if (rightHeld) {velocity[0] += 1;}

        double mag = Math.sqrt(Math.pow(velocity[0], 2) + Math.pow(velocity[1], 2));
        if (mag != 0)
        {
            velocity[0] *= this.speed/mag;
            velocity[1] *= this.speed/mag;
        }

        if (lookingLeft & !lookingRight)
        {
            incViewAngle(-(float)Math.PI);
        }
        if (!lookingLeft & lookingRight)
        {
            incViewAngle((float)Math.PI);
        }

        move(velocity[0], velocity[1]);

    }

    public void setUpHeld(boolean upHeld) {
        this.upHeld = upHeld;
    }

    public void setLeftHeld(boolean leftHeld) {
        this.leftHeld = leftHeld;
    }

    public void setRightHeld(boolean rightHeld) {
        this.rightHeld = rightHeld;
    }
    
    public void setDownHeld(boolean downHeld) {
        this.downHeld = downHeld;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void keyPressed(char c)
    {
        if (c == 'w')
        {
            setUpHeld(true);
        }
        if (c == 'a')
        {
            setLeftHeld(true);
        }
        if (c == 's')
        {
            setDownHeld(true);
        }
        if (c == 'd')
        {
            setRightHeld(true);
        }
        if (c == 'q')
        {
            lookingLeft = true;
        }
        if (c == 'e')
        {
            lookingRight = true;
        }
    }

    public void keyReleased(char c)
    {
        if (c == 'w')
        {
            setUpHeld(false);
        }
        if (c == 'a')
        {
            setLeftHeld(false);
        }
        if (c == 's')
        {
            setDownHeld(false);
        }
        if (c == 'd')
        {
            setRightHeld(false);
        }
        if (c == 'q')
        {
            lookingLeft = false;
        }
        if (c == 'e')
        {
            lookingRight = false;
        }
    }

    public float[] getPos() {
        return pos;
    }

    public float getViewAngle() {
        return viewAngle;
    }

    public void incViewAngle(float value)
    {
        this.viewAngle += value;
    }

    
}
