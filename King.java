import javax.swing.*;



public class King  extends Piece
{
    public King (int x, int y, String s)
    {
        super(x,y,s);
        setIcon(new ImageIcon(s + "king.png"));
    }
    public boolean canMoveTo(int startX, int startY, int newX, int newY, Tile[][] board)
    {
        int hMove = Math.abs(startX - newX);
        int vMove = Math.abs(startY - newY);

        Piece dest = board[newX][newY].getPiece();
        if (dest != null)
        {
            if (dest.getColor().equals(this.getColor()))
            {
                return false;
            }
        }
        return ((hMove == 0 && vMove == 1) || (hMove == 1 && vMove == 0) || (hMove == 1 && vMove == 1));


    }


}






