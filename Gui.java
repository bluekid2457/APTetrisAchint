import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import java.util.Random;
import javax.swing.Timer;

/**
 * Represents a brokerage.
 */

/**
 * Brokerage class
 *
 * @author Achint Aju
 * @version Mar 21, 2021
 */
public class Gui extends JPanel implements ActionListener
{

    static JFrame frame = new JFrame();
    static GamePanel gamePanel = new GamePanel();
    static JPanel menuPanel = new JPanel();
    static JButton start;
    static PLanniing planner;
    private Timer timer;
    public int[][] grid;
    public int[][] tempgrid;

    public Gui()
    {
        System.out.println("Started Gui");
        planner = new PLanniing(this);
        int delay = 10;
        grid = planner.gameArray;
        tempgrid = planner.tempGameArray;
        timer = new Timer(delay,this);

    }
    public void init()
    {
        System.out.println("ye");
    }

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
       // gamePanel.setLayout(new GridLayout(20,10,3,3));


        menuPanel.setBackground(new Color (50,50,50)); //Add stuff like high score and start button and other stuff here
        menuPanel.setBounds(400,20,200,500);
        start =  new JButton("START!");
        start.addActionListener(e -> start());
        menuPanel.add(start);

        frame.add(menuPanel);
        frame.add(gamePanel);
        frame.setVisible(true);
        Gui gui = new Gui();


    }

    public void draw2(Graphics g, int[][] t)
    {
        //paint(g,t);
    }

/*
    public void paintComponent(Graphics g,  int[][] arr)
    {
        int[][] t = arr;
        g.setColor(Color.GREEN);
        g.drawRect(3,3, 20, 20);
        for (int[]i : t)
        {
            System.out.println();
            for (int k : i)
            {
                //System.out.print("|" + k + "|");
                Color color = new Color (0,0,0);
                JPanel block =  new JPanel();
                if (k == 0)
                {
                    color = new Color(250, 250, 250); //White
                }
                else if (k == 1)
                {
                    color = new Color (0,250,0);
                }
                else if (k == 2)
                {
                    color = new Color (250,0,0);
                }
                else if (k == 3)
                {
                    color = new Color (0,0,250);
                }
                else if (k == 7)
                {
                    System.out.println("hey im here");
                    color = new Color (0,0,250);
                }

                //setColor(Color.green);
                block.setBackground(color);
                gamePanel.add(block);
                try
                {
                    Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                frame.add(gamePanel);
                try
                {
                    Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                frame.setVisible(true);
                try
                {
                    Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    */
    public void paint2( int[][] arr)
    {
        int[][] t = arr;
        JButton[][] dispArr = new JButton[arr.length][arr[0].length];
        for(int row = 0; row < 10; row++)
        {
          for(int col = 0; col < 10; col++)
          {
            dispArr[row][col] = new JButton();
            dispArr[row][col].setBackground(Color.BLACK);
            gamePanel.add(dispArr[row][col]);
            frame.setVisible(true);
            //retVal = i;
          }
          //System.out.println("hey");
        }
        /*
        for (int[]i : t)
        {
            System.out.println();
            for (int k : i)
            {
                //System.out.print("|" + k + "|");
                Color color = new Color (0,0,0);
                JPanel block =  new JPanel();
                if (k == 0)
                {
                    color = new Color(250, 250, 250); //White
                }
                else if (k == 1)
                {
                    color = new Color (0,250,0);
                }
                else if (k == 2)
                {
                    color = new Color (250,0,0);
                }
                else if (k == 3)
                {
                    color = new Color (0,0,250);
                }
                else if (k == 7)
                {
                    System.out.println("hey im here");
                    color = new Color (0,0,250);
                }

                //setColor(Color.green);
                block.setBackground(color);
                gamePanel.add(block);
                try
                {
                    Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                frame.add(gamePanel);
                try
                {
                    Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                frame.setVisible(true);
                try
                {
                    Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }*/
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == start) {
            System.out.println("clicker");
        }
        timer.start();
        //paint2();

    }
    public static void start() {
        System.out.println("clicked");
        planner.start();
    }
    public static void update()
    {
        //frame.revalidate();

        frame.repaint();
        gamePanel.repaint();
        System.out.println("CALLING UPDATE");

        planner.mainLoop();
    }
/*
    public static void display(int[][])
    {
        planner.getDisplay();
    }
    */

}
