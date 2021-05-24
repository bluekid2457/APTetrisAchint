import java.lang.reflect.*;
import java.util.*;
import java.util.Random;



/**
 * Shape class
 *
 * @author Achint Aju
 * @version Mar 21, 2021
 * Generates a shape for the tetris board
 */
public class Shape
{
    static Random rand = new Random();
    public int shapenum;
    int rotation = 0;
    public int colornum;
    /**
     * Create a new Shape object. Which is a random shape
     */
    public Shape()
    {
        shapenum = rand.nextInt(3);
        System.out.println(shapenum);
        shapenum = 7;
        colornum = shapenum;

    }

    /**
     * Returns an array of points that makes up the shape
     * @return the int[][] of points that is in the shape
     */
    public int[][] getPoints()
    {
        if (shapenum == 0)
        {
            return ( new int[][] {{0,0},{0,1},{1,0},{1,1}}); // square
        }
        else if (shapenum == 1)
        {
            if (rotation == 0) {
                return ( new int[][] {{0,0},{0,1},{1,0},{2,0}}); // L
            }
            else  if (rotation == 1) {
                return ( new int[][] {{0,0},{0,1},{0,2},{1,2}}); // L
            }
            else  if (rotation == 2) {
                return ( new int[][] {{0,0},{1,0},{2,0},{2,-1}}); // L
            }
            else  if (rotation == 3) {
                return ( new int[][] {{0,0},{0,1},{1,0},{0,2}}); // L
            }
        }
        else if (shapenum == 2)
        {
            if (rotation == 0)
            {
            return ( new int[][] {{0,0},{2,1},{1,0},{2,0}}); // Reverse L
            }
            else  if (rotation == 1) {
                return ( new int[][] {{0,0},{0,1},{1,0},{0,2}}); // Reverse L
            }
            else  if (rotation == 2) {
                return ( new int[][] {{0,0},{0,-1},{1,0},{2,0}}); // Reverse L
            }
            else  if (rotation == 3) {
                return ( new int[][] {{0,0},{0,-1},{1,0},{1,1}}); // Reverse L
            }
        }
        else if (shapenum == 3)
        {
            if (rotation == 0)
            {
                return ( new int[][] {{0,0},{1,1},{1,0},{2,0}}); // T
            }
            else  if (rotation == 1) {
                return ( new int[][] {{0,0},{1,0},{0,1},{0,-1}}); // T
            }
            else  if (rotation == 2) {
                return ( new int[][] {{0,0},{1,-1},{1,0},{2,0}}); // T
            }
            else  if (rotation == 3) {
                return ( new int[][] {{0,0},{-1,0},{0,-1},{0,1}}); // T
            }

        }
        else if (shapenum == 4)
        {
            if (rotation == 0 || rotation == 2) {
                return ( new int[][] {{0,0},{3,0},{1,0},{2,0}}); // Long
            }
            else  if (rotation == 1 || rotation == 3) {
                return ( new int[][] {{0,0},{0,-1},{0,1},{0,2}}); // Long
            }
        }
        else if (shapenum == 7)
        {
            return (new int[][] {{0,0}});
        }
        return null;

    }

    /**
     * Rotates the shape
     */
    public void rotate()
    {
        rotation +=1;
        rotation %=4;
        /*if (rotation  == 4)
        {
            rotation = 0;
        }*/
    }

    /**
     * Returns color of the block
     * @return Color of the block
     */
    public int getColor()
    {
        return colornum;
    }

}
