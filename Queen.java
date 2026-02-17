import javax.swing.*;




public class Queen extends Piece
{
    boolean canMoveVertical;
    boolean canMoveDiagonal;


    public Queen(int x, int y, String s)
    {
        super(x, y, s);
        canMoveDiagonal = true;
        canMoveVertical = true;
        setIcon(new ImageIcon(s + "queen.png"));
    }
    public Queen(int x, int y, String s, boolean b1, boolean b2)
    {
        super(x, y, s);
        canMoveVertical = b1;
        canMoveDiagonal = b2;
    }


    public boolean canMoveTo(int startX, int startY, int newX, int newY, Tile[][] board)
    {
        if (startX == newX && startY == newY)
        {
            return false;
        }
        int changeX = newX - startX;
        int changeY = newY - startY;
        int hMove = Math.abs(changeX);
        int vMove = Math.abs(changeY);
        // Must be straight OR diagonal
        if(canMoveVertical && canMoveDiagonal)
        {
            if (!((changeX == 0 || changeY == 0) || (hMove == vMove)))
            {
                return false;
            }
        }
        else if(canMoveDiagonal)
        {
            if(hMove != vMove)
            {
                return false;
            }
            if (!((changeX == 0 || changeY == 0) || (hMove == vMove)))
            {
                return false;
            }
        }
        else if(canMoveVertical)
        {
            if(!((changeX == 0 || changeY == 0)))
            {
                return false;
            }


            if (!((changeX == 0 || changeY == 0) || (hMove == vMove)))
            {
                return false;
            }


        }


        int stepX = 0;
        if (newX > startX)
        {
            stepX = 1;
        }
        else if (newX < startX)
        {
            stepX = -1;
        }


        int stepY = 0;
        if (newY > startY)
        {
            stepY = 1;
        }
        else if (newY < startY)
        {
            stepY = -1;
        }
        int x = startX + stepX;
        int y = startY + stepY;
        while (x != newX || y != newY)
        {
            if (board[x][y].getPiece() != null)
            {
                return false;
            }
            x = x + stepX;
            y = y + stepY;
        }
        Piece dest = board[newX][newY].getPiece();
        if (dest != null)
        {
            if (dest.getColor().equals(this.getColor()))
            {
                return false;
            }
        }
        return true;
    }
}


