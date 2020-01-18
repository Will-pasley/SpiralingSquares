import java.util.ArrayList;

public class Squares
{
    public Squares()
    {

    }

    public int[][] getNextSquare(int[][] vertices, int alpha)
    {
        int[][] nextSquare = new int[][]{{0,0},{0,0},{0,0},{0,0},{0,0}};
        for(int i = 0; i<4;i++)
        {
            for(int j = 0; j < 2; j++)
            {
                nextSquare[i][j] = (int) ((1-alpha)*vertices[i][j]+alpha*vertices[i+1][j]);
            }
        }
        nextSquare[4][0] = nextSquare[0][0];
        nextSquare[4][1] = nextSquare[0][1];
        return nextSquare;
    }
}
