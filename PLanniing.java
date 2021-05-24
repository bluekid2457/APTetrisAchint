import java.lang.reflect.*;
import javax.swing.JFrame;
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
public class PLanniing
{
    public int[][] gameArray = new int [21][12]; //adds points once set/ resting
    public int[][]tempGameArray;
    Random rand = new Random();
    Gui g;
    public PLanniing(Gui gr)
    {
        System.out.println("welcome");
        g = gr;

    }

    public void start()
    {
        System.out.println("planner start");

        //set the array with the very outer ones sa a number that corresponds to black or border
        for (int i = 0; i < 20; i++)
        {
            gameArray[i] = new int[] {10 ,0,0,0,0,0,0,0,0,0,0,10};
        }
        gameArray[20] = new int[] {10,10,10,10, 10,10,10,10,10,10,10,10};
        boolean dead = false;
        mainLoop();

        while (!dead) //Game loop
        {
            //mainLoop();
        }
    }
    public void mainLoop()
    {
        int x = 5;
        int y = 0;

        System.out.println(" looping");
        Shape tetramino = generateShape();
        int colornum = tetramino.colornum;
        boolean placed = false;
        //System.out.println("newblock");

        while (!placed)
        {
            int delay = 1000;
            //System.out.println("reseting");
            tempGameArray = gameArray;
            tempGameArray[20] = new int[] {20,20,20,20,10,20,20,20,20,20,20,10};
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
        //g.paint2(t);
        System.out.println("REPAINTINGINGING");
        Gui.update();
        System.out.println("REPAINTINGINGING");

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
