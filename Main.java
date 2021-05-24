import java.awt.Color;
import java.awt.GridLayout;
import java.lang.reflect.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.*;

import java.util.Random;

/**
 * Represents a brokerage.
 */

/**
 * Brokerage class
 *
 * @author Achint Aju
 * @version Mar 21, 2021
 */
public class Main
{
    static JFrame frame = new JFrame();
    static JPanel gamePanel = new JPanel();
    static JPanel menuPanel = new JPanel();
    static JButton start;
    static PLanniing planner;
    private Timer timer;
    public static Gui gui = new Gui();
    Random rand = new Random();
    public static void main(String args[])
    {
        frame.setTitle("GUYEE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(600, 720);

        //frame.getContentPane().setBackground(new Color(50,0,50));
        frame.setLayout(null);

        gamePanel.setBackground(new Color  (250,0,0));
        gamePanel.setBounds(20,20,333, 666);
        gamePanel.setLayout(new GridLayout(20,10,3,3));


        menuPanel.setBackground(new Color (50,50,50)); //Add stuff like high score and start button and other stuff here
        menuPanel.setBounds(400,20,200,500);
        start =  new JButton("START!");
        start.addActionListener(e -> start());
        menuPanel.add(start);

        frame.add(menuPanel);
        frame.setVisible(true);

        gui.init();
        frame.add(gui);
        frame.pack();
        planner = new PLanniing (gui);


    }

    public static void start()
    {
        planner.start();
    }
    public Shape generateShape()
    {
        Shape s = new Shape();

        return s;
    }

    public void addShape(int[][] arr, Shape tS, int x, int y)
    {
        int[][]t = tS.getPoints();
        int colornum = tS.colornum;
        for (int[] i : t)
        {
            int posx = i[0] + x;
            int posy = i[1] + y;
            arr[posy][posx] = colornum;
        }
    }
    public void display(int[][] t)
    {
        gui.paint(null, t);
    }

    public void checkRow(int[][] t)
    {

        int col = 0;
        for (int[] i : t)
        {
            for (int k : i)
            {
                boolean completed = true;
                if (k == 0)
                {
                    completed = false;
                }
                if (completed)
                {
                    removeCol(col,t);
                }

            }
            col++;
        }
    }

    public void removeCol(int c, int[][]arr)
    {
        while (c != 1)
        {
            int [] topCol = arr[c-1];
            arr[c] = topCol;
            c--;
        }
        arr[0] = new int[] {10 ,0,0,0,0,0,0,0,0,0,0,10};
    }

}
    /*
    public static void start()
    {
        int[][] gameArray = new int [21][12]; //adds points once set/ resting
        //set the array with the very outer ones sa a number that corresponds to black or border
        for (int i = 0; i < 20; i++)
        {
            gameArray[i] = new int[] {10 ,0,0,0,0,0,0,0,0,0,0,10};
        }
        gameArray[20] = new int[] {10,10,10,10, 10,10,10,10,10,10,10,10};
        boolean dead = false;
        while (!dead) //Game loop
        {
            int x = 5;
            int y = 0;


            Shape tetramino = generateShape();
            int colornum = tetramino.colornum;
            boolean placed = false;
            System.out.println("newblock");

            while (!placed)
            {
                int delay = 1000;
                int[][]tempGameArray;
                System.out.println("reseting");
                tempGameArray = gameArray;
                tempGameArray[20] = new int[] {20,20,20,20, 10,20,20,20,20,20,20,10};
                boolean left = false;
                boolean right  = false;
                boolean down = true;
                boolean up = false;
                //if input kwy left or right make true
                if (left)
                {
                    for (int[] i : tetramino.getPoints())
                    {
                        int  xMod = i[0];
                        int yMod = i[1];
                        //int colorNum = i[2];
                        if (gameArray[yMod+y][xMod+x-1] == 0)
                        {
                            x--;
                        }
                    }
                }
                else if (right)
                {
                    for (int[] i : tetramino.getPoints())
                    {
                        int xMod = i[0];
                        int yMod = i[1];
                        //int colorNum = i[2];
                        if (gameArray[yMod+y][xMod+x+1] == 0)
                        {
                           x++;
                        }
                    }
                }
                if (down)
                {
                    delay  = 500; //or some other number likr half of delay cause wehn level speeds up
                }
                if (up)
                {
                    tetramino.rotate();
                }

                for (int[] i : tetramino.getPoints())
                {
                    int  xMod = i[0];
                    int yMod = i[1];
                    System.out.println(yMod+y);
                    //int colorNum = i[2];
                    System.out.println(gameArray[yMod+y][5]);
                    if (gameArray[yMod+y+1][xMod+x] == 0)
                    {
                       y++;
                       //addShape(tempGameArray, tetramino,x,y);
                       display(tempGameArray);
                       System.out.println(" NOT BOTTOM");
                       try
                       {
                           Thread.sleep(delay);
                       }
                       catch (InterruptedException e)
                       {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                       }
                    }
                    else
                    {
                        placed = true;
                        addShape(gameArray, tetramino,x,y);
                        display(gameArray);
                        System.out.println(" OTTOM");
                        try
                        {
                            Thread.sleep(delay);
                        }
                        catch (InterruptedException e)
                        {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
                }

            }
        }
    }
    */
    /**
     * Place a description of your method here.
     * for (int[] i : tetramino)
            {
                int  xMod = i[0];
                int yMod = i[1];
                int colorNum = i[2];
            }
     * @return list of point modifiers that make up the shape
     */

