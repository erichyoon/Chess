import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Chess extends JFrame implements ActionListener
{
    private Tile board[][];
    private int columns = 8;
    private int rows = 8;
    private int size = 100;
    private Tile selected = null;


    public Chess() {
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setBackground(Color.BLACK);
        setTitle("Chess but cool");
        setSize(1250,1250);
        setResizable(false);
        setLocation(700, 250);
        board = new Tile[columns][rows];
        for(int y = 0; y < rows; y++)
        {
            for(int x = 0; x < columns; x++)
            {
                board[x][y] = new Tile("",x,y);
                board[x][y].setBackground(boardColor(x, y));
                board[x][y].setBounds(100+ (x*size), 100 + (y*size), size, size);
                board[x][y].addActionListener(this);
                contentPane.add(board[x][y]);
                JLabel letterLabel = new JLabel(letterPosition(x,y));
                letterLabel.setBounds(145 + (x*size), 865, size, size);
                letterLabel.setForeground(Color.WHITE);
                letterLabel.setFont(new Font("Serif", Font.PLAIN, 18));
                contentPane.add(letterLabel);
                JLabel numberLabel = new JLabel(numberPosition(x,y));
                numberLabel.setBounds(85, 100+ (x*size), size, size);
                numberLabel.setForeground(Color.WHITE);
                numberLabel.setFont(new Font("Serif", Font.PLAIN, 18));
                contentPane.add(numberLabel);
                piecePlacer(x,y);
            }
        }
    }


    public Color boardColor(int x, int y)
    {
        Color color;
        if((x+y) % 2 == 0)
        {
            color = Color.WHITE;
        }
        else
        {
            color = Color.GRAY;
        }
        return color;
    }
































    public String letterPosition(int x, int y)
    {
        String s = "abcdefgh";
        String sigmaS = "";
        if (x == 7)
        {
            sigmaS = s.substring(x);
        }
        else
        {
            sigmaS = s.substring(x, x+1);
        }
        return sigmaS;
    }
    public String numberPosition(int x, int y)
    {
        String s = "87654321";
        String sigmaS ="";
        if(y == 0)
        {
            sigmaS = s.substring(x, x+1);
        }
        return sigmaS;
    }
    public void piecePlacer(int x, int y)
    {
        Pawn whitePawn = new Pawn(x, y, "white");
        Pawn blackPawn = new Pawn(x, y, "black");
        Knight whiteKnight = new Knight(x, y, "white");
        Knight blackKnight = new Knight(x, y, "black");
        Bishop whiteBishop = new Bishop(x, y, "white");
        Bishop blackBishop = new Bishop(x, y, "black");
        King whiteKing = new King(x, y, "white");
        King blackKing = new King(x, y, "black");
        Queen whiteQueen = new Queen(x, y, "white");
        Queen blackQueen = new Queen(x, y, "black");
        Rook whiteRook = new Rook(x, y, "white");
        Rook blackRook = new Rook(x, y, "black");








        if (y == 1)
        {
            board[x][y].setPiece(blackPawn);
        }
        else if (y == 6)
        {
            board[x][y].setPiece(whitePawn);
        }
        else if (y == 0 && (x == 1 || x == 6))
        {
            board[x][y].setPiece(blackKnight);
        }
        else if (y == 7 && (x == 1 || x == 6))
        {
            board[x][y].setPiece(whiteKnight);
        }
        else if (y == 0 && (x == 2 || x == 5))
        {
            board[x][y].setPiece(blackBishop);
        }
        else if (y == 7 && (x == 2 || x == 5))
        {
            board[x][y].setPiece(whiteBishop);
        }
        else if (y == 0 && (x == 0 || x == 7))
        {
            board[x][y].setPiece(blackRook);
        }
        else if (y == 7 && (x == 0 || x == 7))
        {
            board[x][y].setPiece(whiteRook);
        }
        else if (y == 0 && x == 3)
        {
            board[x][y].setPiece(blackQueen);
        }
        else if (y == 7 && x == 3)
        {
            board[x][y].setPiece(whiteQueen);
        }
        else if (y == 0 && x == 4)
        {
            board[x][y].setPiece(blackKing);
        }
        else if (y == 7 && x == 4)
        {
            board[x][y].setPiece(whiteKing);
        }
    }












    public void actionPerformed (ActionEvent e)
    {
        Tile clickedButton = (Tile) e.getSource();








        if (selected == null)
        {


            if (clickedButton.getPiece() != null)
            {
                selected = clickedButton;
            }
        }
        else
        {
            int initialX = selected.getColumn();
            int initialY = selected.getRow();
            int endX = clickedButton.getColumn();
            int endY = clickedButton.getRow();
            Piece p = selected.getPiece();










            if (p.canMoveTo(initialX, initialY, endX, endY, board))
            {
                clickedButton.setPiece(p);
                selected.setPiece(null);
                selected.setIcon(null);


            }
            selected = null;
        }








    }




    public static void main (String[]args)
    {
        Chess frame = new Chess();
        frame.setVisible(true);
    }








}






























