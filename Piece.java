import javax.swing.*;


public class Piece
{
    private int x;
    private int y;
    private String s;
    private ImageIcon icon;




    public Piece(int x, int y, String s)
    {
        this.x = x;
        this.y = y;
        this.s = s;
    }


    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public String getColor()
    {
        return s;
    }
    public ImageIcon getIcon()
    {
        return icon;
    }
    public void setIcon(ImageIcon icon)
    {
        this.icon = icon;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public boolean canMoveTo(int startX, int startY, int newX, int newY, Tile[][]board)
    {
        return false;
    }
}


