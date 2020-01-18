import javax.swing.*;
import java.awt.*;

//Will Pasley
public class Controller
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Spiraling Squares");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = new Canvas();
        GUI gui = new GUI(canvas);

        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.BLACK);
        frame.add(canvas, BorderLayout.CENTER);
        frame.add(gui, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }
}
