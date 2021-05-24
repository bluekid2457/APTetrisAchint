import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class GamePanel extends Canvas{
    Random r = new Random();
    public void paint(Graphics g)
        {
            super.paint(g);
            g.setColor(Color.BLUE);
            g.fillRect(150,50,30,200);
            System.out.println("paint compomnet ran !!!!!!!!!!");
            int k = r.nextInt(3);
            if (k==1)
            {
                g.setColor(Color.GREEN);
                g.fillRect(150,50,30,200);
            }
            else if(k==2)
            {
                g.setColor(Color.ORANGE);
                g.fillRect(150,50,30,200);
            }

        }
    /*
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
                add(block);
                try
                {
                    Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try
                {
                    Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
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
    }*/
}