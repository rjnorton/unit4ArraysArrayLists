

/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test
{
    public static void main(String[] args)
    {
        int[][] dydx = new int[36][3];
        int j = 0;
        for (int i = 0; i<= 35; i++)
        {
            dydx[i][0] = j;
            j++;
            if ((j%6) == 0){j=0;}
            if (i >= 0){dydx[i][1] = 0;}
            if (i > 5){dydx[i][1] = 1;}
            if (i >= 12){dydx[i][1] = 2;}
            if (i >= 18){dydx[i][1] = 3;}
            if (i >= 24){dydx[i][1] = 4;}
            if (i >= 30){dydx[i][1] = 5;}
            dydx[i][2] = 0;
        }
        for (int[] list : dydx)
        {
            System.out.println("{"+list[0]+","+list[1]+","+list[2]+"}");
        }
    }

}
