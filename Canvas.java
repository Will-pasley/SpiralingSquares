import java.awt.*;
import javax.swing.*;


public class Canvas extends JPanel
{
   int[][] currentVerts;
   int[][] newVerts;
   Double lamda;
   int numSquares;
   boolean singleSquare;
   int rows;
   int cols;
   int smaller;
   boolean direction;
   Color myColor;

    //Canvas initiator, gives some default values.
    public Canvas()
    {
        setPreferredSize(new Dimension(400,400));
        setBackground(Color.BLACK);

        lamda = 0.35;
        numSquares = 10;

        rows = 5;
        cols = 5;

        singleSquare = true;
        myColor = new Color(238,238,238);
    }

    //Paints the squares
    @Override
    public void paintComponent(Graphics g)
    {
        try {
            super.paintComponents(g);

            Graphics2D g2d = (Graphics2D) g;

            g2d.setStroke(new BasicStroke(1));
            g2d.setPaint(myColor);

            direction = true;

            //For a single square
            if (singleSquare) {
                currentVerts = new int[][]{{0, 0}, {400, 0}, {400, 400}, {0, 400}, {0, 0}};
                newVerts = currentVerts;

                //Draws the initial square
                g2d.drawLine(currentVerts[0][0], currentVerts[0][1], currentVerts[1][0], currentVerts[1][1]);
                g2d.drawLine(currentVerts[1][0], currentVerts[1][1], currentVerts[2][0], currentVerts[2][1]);
                g2d.drawLine(currentVerts[2][0], currentVerts[2][1], currentVerts[3][0], currentVerts[3][1]);
                g2d.drawLine(currentVerts[3][0], currentVerts[3][1], currentVerts[4][0], currentVerts[4][1]);

                //Draws the spiraling squares
                for (int i = 0; i < numSquares; i++) {
                    newVerts = getNextSquare(currentVerts, lamda);
                    g2d.drawLine(newVerts[0][0], newVerts[0][1], newVerts[1][0], newVerts[1][1]);
                    g2d.drawLine(newVerts[1][0], newVerts[1][1], newVerts[2][0], newVerts[2][1]);
                    g2d.drawLine(newVerts[2][0], newVerts[2][1], newVerts[3][0], newVerts[3][1]);
                    g2d.drawLine(newVerts[3][0], newVerts[3][1], newVerts[4][0], newVerts[4][1]);
                    currentVerts = newVerts;
                }
            }
            //For A grid of squares
            else {
                int height = 0 + (400 / rows);
                int width = 0 + (400 / cols);
                if (height >= width) {
                    smaller = width;
                }
                else {
                    smaller = height;
                }
                //Nested for loop to get the upper left hand corner for each square
                for (int i = 0; i < rows; i++) {
                    if (cols %2 == 0 && i > 0){
                        if (direction) {
                            direction = false;
                        } else {
                            direction = true;
                        }
                    }
                    for (int j = 0; j < cols; j++) {
                        //Gets updated starter coordinates for each grid square
                        currentVerts = new int[][]{{(0 + smaller * j), (0 + smaller * i)}, {smaller + smaller * j, 0 + smaller * i}, {smaller + smaller * j, smaller + smaller * i}, {0 + smaller * j, smaller + smaller * i}, {0 + smaller * j, 0 + smaller * i}};
                        newVerts = currentVerts;
                        g2d.drawLine(currentVerts[0][0], currentVerts[0][1], currentVerts[1][0], currentVerts[1][1]);
                        g2d.drawLine(currentVerts[1][0], currentVerts[1][1], currentVerts[2][0], currentVerts[2][1]);
                        g2d.drawLine(currentVerts[2][0], currentVerts[2][1], currentVerts[3][0], currentVerts[3][1]);
                        g2d.drawLine(currentVerts[3][0], currentVerts[3][1], currentVerts[4][0], currentVerts[4][1]);
                        //Spirals each grid square
                        for (int k = 0; k < numSquares; k++) {
                            double lamdaDir;
                            if (direction == false) {
                                lamdaDir = 1.0 - lamda;
                            } else {
                                lamdaDir = lamda;
                            }
                            newVerts = getNextSquare(currentVerts, lamdaDir);
                            g2d.drawLine(newVerts[0][0], newVerts[0][1], newVerts[1][0], newVerts[1][1]);
                            g2d.drawLine(newVerts[1][0], newVerts[1][1], newVerts[2][0], newVerts[2][1]);
                            g2d.drawLine(newVerts[2][0], newVerts[2][1], newVerts[3][0], newVerts[3][1]);
                            g2d.drawLine(newVerts[3][0], newVerts[3][1], newVerts[4][0], newVerts[4][1]);
                            currentVerts = newVerts;
                        }
                        //alternates direction for each iteration
                        if (direction) {
                            direction = false;
                        } else {
                            direction = true;
                        }
                    }
                }
            }
        }
        catch(ArithmeticException ae){}
    }

    //Method to get the coordinates for the next square
    public int[][] getNextSquare(int[][] vertices, Double lamda)
    {
        int[][] nextSquare = new int[][]{{0,0},{0,0},{0,0},{0,0},{0,0}};
        for(int i = 0; i<4;i++)
        {
            for(int j = 0; j < 2; j++)
            {
                nextSquare[i][j] = (int) ((1-lamda)*vertices[i][j]+lamda*vertices[i+1][j]);
            }
        }
        nextSquare[4][0] = nextSquare[0][0];
        nextSquare[4][1] = nextSquare[0][1];
        return nextSquare;
    }

    public void setLamda(Double newLamda)
    {
        lamda = newLamda;
    }

    public void setNumSquares(int newNumSquares)
    {
        numSquares = newNumSquares;
    }

    public void setStyle(String style)
    {
        if (style == "Single")
        {
            singleSquare = true;
        }
        else
        {
            singleSquare = false;
        }
    }

    public void setCols(int num)
    {
        cols = num;
    }
    public void setRows(int num)
    {
        rows = num;
    }
    public void setMyColor(Color color)
    {
        myColor = color;
    }
}
