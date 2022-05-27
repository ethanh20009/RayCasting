import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class MyPanel extends JPanel {

    private ArrayList<RayCastable> objectsToDraw;
    private Player player;
    
    public MyPanel()
    {
        this.setPreferredSize(new Dimension(1000, 500));
        this.objectsToDraw = new ArrayList<RayCastable>();
        this.objectsToDraw.add(new Wall(100, 100, 500, 100));
        this.objectsToDraw.add(new Wall(500, 100, 500, 500));
        this.objectsToDraw.add(new Wall(500, 500, 100, 500));
        this.objectsToDraw.add(new Wall(200, 200, 300, 300));
        this.objectsToDraw.add(new Wall(100, 500, 100, 100));
        this.player = new Player();
        this.player.setPosition(200, 200);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        // for (RayCastable d : this.objectsToDraw)
        // {
        //     d.draw(g2D);
        // }

        this.player.update();
        g2D.setPaint(Color.RED);
        g2D.fillRect(0, 250, 1000, 250);
        g2D.setPaint(Color.BLACK);
        g2D.setPaint(Color.BLUE);
        g2D.fillRect(0, 0, 1000, 250);
        g2D.setPaint(Color.BLACK);
        //this.player.draw(g2D);

        // Vector castVector = new Vector(this.player.getPos()[0], this.player.getPos()[1], this.player.getPos()[0] + 50, this.player.getPos()[1]-100);
        // float[] intersectpos = Vector.findIntersect(castVector, this.objectsToDraw.get(0).getVector());
        // g2D.drawLine((int)castVector.x1, (int)castVector.y1, (int)castVector.x2, (int)castVector.y2);
        // if (intersectpos != null)
        // {
        //     g2D.drawOval((int)intersectpos[0], (int)intersectpos[1], 10, 10);
        // }


        for (int i = -500; i < 500; i++) //Create rays
        {
            Vector castVector = new Vector(this.player.getPos()[0], this.player.getPos()[1], this.player.getPos()[0], this.player.getPos()[1]-1000); //Make a ray
            castVector = castVector.rotate(((float)((float)i)/(float)(Math.PI*5)) + this.player.getViewAngle()); //Rotate ray
            //g2D.drawLine((int)castVector.x1, (int)castVector.y1, (int)castVector.x2, (int)castVector.y2); //Draw ray

            //Set lowest intersect mag
            float lowestMag = 1000;
            for (RayCastable obj : this.objectsToDraw) //Find lowest magnitude
            {
                float[] intersectPos = Vector.findIntersect(castVector, obj.getVector());
                if (intersectPos != null)
                {
                    float mag = Vector.magnitude(new Vector(this.player.getPos()[0], this.player.getPos()[1], intersectPos[0], intersectPos[1]));
                    if (mag < lowestMag) {lowestMag = mag;}
                    //g2D.drawOval((int)intersectPos[0]-5, (int)intersectPos[1]-5, 10, 10);
                }
                
            }
            int lineHeight = (int)(2500/Math.sqrt(lowestMag));
            g2D.setPaint(new Color((float)Math.pow((1000-lowestMag)/1000, 2), (float)Math.pow((1000-lowestMag)/1000, 2), (float)Math.pow((1000-lowestMag)/1000, 2)));
            g2D.drawLine(i + 500, 250-lineHeight/2, i + 500, 250+lineHeight/2);
            g2D.setPaint(Color.BLACK);

        }

        

    }

    public Player getPlayer() {
        return player;
    }

    
    
}
