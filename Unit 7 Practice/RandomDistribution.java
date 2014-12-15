import java.util.Scanner;

public class RandomDistribution
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        
        System.out.print("How many random numbers do you want to generate?: ");
        int num = s.nextInt();
        
        System.out.print("What is the number of values for each random draw?: ");
        int num2 = s.nextInt();
        
        int[] array = new int[num2];
        int rand;
        
        for (int i = 0; i < num; i++)
        {
            rand = (int)(Math.random() * num2);
            array[rand] += 1;
        }
        
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(i + "     " + array[i]);
        }
    }
}
