import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Tile extends JButton
{
    private int column;
    private int row;
    private boolean isPawn;
    Piece piece;








    public Tile(String s, int x, int y)
    {
        super(s);
        column = x;
        row = y;
















        /**
         piece = new Piece[6];








         piece[0] = new Queen();
         piece[1] = new King();
         piece[2] = new Knight();
         piece[3] = new Pawn();
         piece[4] = new Rook();
         piece[5] = new Bishop();
         **/
    }
    public Piece getPiece()
    {
        return piece;
    }
    public void setPiece(Piece p)
    {
        piece = p;
        if (p != null)
        {
            setIcon(p.getIcon());
        }
        else
        {
            setIcon(null);
        }
    }




    public int getColumn()
    {
        return column;
    }
    public int getRow()
    {
        return row;
    }








}
















