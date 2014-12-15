
public class ArrayOperations
{
    int[] array;
    public ArrayOperations()
    {
        int[] values = {8,4,5,21,7,9,18,2,100};
        this.array = values;
    }

    public void printLength()
    {
        System.out.println("Length: " + array.length);
    }
    
    public void printFirst()
    {
        System.out.println("First element: " + array[0]);
    }
    
    public void printLast()
    {
        System.out.println("Last element: " + array[8]);
    }
    
    public void printLastAlso()
    {
        System.out.println("Last element: " + array[array.length - 1]);
    }
    
    public void print1()
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
    
    public void print2()
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("Element num: " + i + " Value: " + array[i]);
        }
    }
    
    public void print3()
    {
        for (int i = array.length-1; i >= 0; i--)
        {
            System.out.println(array[i]);
        }
    }
    
    public void print4()
    {
        for (int val : array)
        {
            System.out.println(val);
        }
    }

}
