import javax.swing.*;


public class Rook extends Queen
{
    public Rook (int x, int y, String s)
    {
        super(x,y,s, true, false);
        setIcon(new ImageIcon(s + "rook.png"));
    }
}


