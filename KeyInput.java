import java.awt.event.*;


public class KeyInput extends KeyAdapter{

    private Player player;

    public KeyInput(Player player)
    {
        this.player = player;
    }

    public void keyPressed(KeyEvent e)
    {
        this.player.keyPressed(e.getKeyChar());
    }

    public void keyReleased(KeyEvent e)
    {
        this.player.keyReleased(e.getKeyChar());
    }
}
