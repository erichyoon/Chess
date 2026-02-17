import javax.swing.*;




public class Knight  extends Piece
{
    public Knight (int x, int y, String s)
    {
        super(x,y,s);
        setIcon(new ImageIcon(s + "knight.png"));
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
        return ((hMove == 1 && vMove == 2) || (hMove == 2 && vMove == 1));








    }
}
































