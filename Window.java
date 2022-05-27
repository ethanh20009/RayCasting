import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable{

    private MyPanel panel;
    
    public Window()
    {
        this.panel = new MyPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);
        this.pack();
        addKeyListener(new KeyInput(panel.getPlayer()));
        this.setVisible(true);
    }

    @Override
    public void run() {

        try{
            while (true)
            {
                this.panel.repaint();
                Thread.sleep(1000/60);
            }

        }catch(InterruptedException e)
        {
            //Ignore
        }
        
    }
    

    public static void main(String[] args)
    {
        Window window = new Window();
        Thread windowThread = new Thread(window);
        windowThread.start();
    }



    

}