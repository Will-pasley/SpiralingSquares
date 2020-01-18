import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ActionListener
{

    private JButton run;
    private TextField lamda;
    private JLabel lamdaLabel;
    private JButton lamdaSet;
    private Canvas canvas;
    private JLabel numLabel;
    private TextField number;
    private JButton numSet;
    private JComboBox<String> style;
    private JLabel styleLabel;
    private JLabel rowsLabel;
    private TextField rows;
    private JButton rowsSet;
    private JLabel colsLabel;
    private TextField cols;
    private JButton colsSet;
    private JLabel empty;
    private JLabel empty2;
    private JLabel empty3;
    private JLabel empty4;
    private JLabel empty5;
    private JLabel empty6;
    private JLabel empty7;


    public GUI(Canvas c)
    {
        canvas = c;
        setPreferredSize(new Dimension(400,400));
        setBackground(Color.GRAY);

        run = new JButton("Run");
        run.addActionListener(this);

        empty = new JLabel(" ");
        empty2 = new JLabel(" ");
        empty3 = new JLabel(" ");
        empty4 = new JLabel(" ");
        empty5 = new JLabel(" ");
        empty6 = new JLabel(" ");
        empty7 = new JLabel(" ");

        lamdaLabel = new JLabel("Input Lamda (between 0 and 1):");
        lamda = new TextField();
        lamdaSet = new JButton("Set Lamda");
        lamdaSet.addActionListener(this);

        numLabel = new JLabel("Input Number of Squares:");
        number = new TextField();


        numSet = new JButton("Set Number");
        numSet.addActionListener(this);

        style = new JComboBox<>();
        style.addItem("Single");
        style.addItem("Grid");

        styleLabel = new JLabel("Single or Grid:");

        rowsLabel = new JLabel("Input Number of Rows: ");
        rows = new TextField();
        rowsSet = new JButton("Set Rows");
        rowsSet.addActionListener(this);

        colsLabel = new JLabel("Input Number of Columns: ");
        cols = new TextField();
        colsSet = new JButton("Set Columns");
        colsSet.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setLayout(new GridLayout(0,2, 1, 4));
        panel.add(run);
        panel.add(empty);
        panel.add(lamdaLabel);
        panel.add(empty2);
        panel.add(lamda);
        panel.add(lamdaSet);
        panel.add(numLabel);
        panel.add(empty3);
        panel.add(number);
        panel.add(numSet);
        panel.add(styleLabel);
        panel.add(empty4);
        panel.add(style);
        panel.add(empty5);
        panel.add(rowsLabel);
        panel.add(empty6);
        panel.add(rows);
        panel.add(rowsSet);
        panel.add(colsLabel);
        panel.add(empty7);
        panel.add(cols);
        panel.add(colsSet);
        add(panel);


    }

    //Action events
    public void actionPerformed(ActionEvent e)
    {
        try {
            if (e.getSource() == run) {
                canvas.setStyle((String) style.getSelectedItem());
                canvas.setMyColor(Color.RED);
                canvas.repaint();
            }
            if (e.getSource() == lamdaSet) {
                Double newLamda = Double.valueOf(lamda.getText());
                canvas.setLamda(newLamda);
            }
            if (e.getSource() == numSet) {
                int newNumber = Integer.valueOf(number.getText());
                canvas.setNumSquares(newNumber);
            }
            if (e.getSource() == rowsSet) {
                int newRows = Integer.valueOf(rows.getText());
                canvas.setRows(newRows);
            }
            if (e.getSource() == colsSet)
            {
                int newCols = Integer.valueOf(cols.getText());
                canvas.setCols(newCols);
            }
        }
        catch(NumberFormatException nfe){

        }
    }

}
