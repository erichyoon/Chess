import javax.swing.*;


public class Pawn extends Piece
{
    boolean ifMoved = false;


    public Pawn(int x, int y, String s)
    {
        super(x, y, s);
        setIcon(new ImageIcon(s + "pawn.png"));
    }


    public boolean canMoveTo(int startX, int startY, int newX, int newY, Tile[][] board)
    {
        int hMove = startX - newX;
        int vMove = startY - newY;


        Piece dest = board[newX][newY].getPiece();


        if (dest != null)
        {
            if (dest.getColor().equals(this.getColor()))
            {
                return false;
            }
        }


        if (!ifMoved)
        {
            ifMoved = true;
            System.out.println("hawk tuah");
            return ((hMove == 0 && vMove == 1) || (hMove == 0 && vMove == 2));
        }
        else
        {
            System.out.println("dont be rash");
            return (hMove == 0 && vMove == 1);
        }
    }
}
































