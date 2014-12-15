
public class ArrayOperations2
{
    public int[] values;
    
    public ArrayOperations2(int [] initialValues)
    {
        values = initialValues;
    }
    
    public void swapFirstLast()
    {
        int temp = values[0];
        values[0] = values[values.length - 1];
        values[values.length - 1] = temp;
    }
    
    public void shiftRight()
    {
        int[] temp = new int[values.length];
        for (int i = 0; i < values.length; i++)
        {
            temp[i] = values[i];
        }
        
        for (int i = 1; i < values.length; i++)
        {
            if (i == (values.length - 1))
            {
                values[i] = temp[i-1];
                values[0] = temp[i];
            }
            
            else
            {
                values[i] = temp[i-1];
            }
        }
    }
    
    public void replaceEven()
    {
        for (int i = 0; i < values.length; i++)
        {
            if ((values[i] % 2) == 0)
            {
                values[i] = 0;
            }
        }
    }
    
    public void replaceByNeighbors()
    {
        int[] temp = new int[values.length];
        for (int i = 0; i < values.length; i++)
        {
            temp[i] = values[i];
        }
        
        for (int i = 1; i < (values.length - 1); i++)
        {
            if (temp[i-1] <= temp[i+1])
            {
                values[i] = temp[i+1];
            }
            
            else
            {
                values[i] = temp[i-1];
            }
        }
    }
    
    public void removeMiddle()
    {
        int[] newarray;
        if ((values.length % 2) == 0)
        {
            newarray = new int[values.length-2];
            for (int i = 0; i < values.length; i++)
            {
                if (i < ((values.length/2)-1))
                {
                    newarray[i] = values[i];
                }
                    
                else if (i > (values.length/2))
                {
                    newarray[i-2] = values[i];
                }
            }
        }
        
        else
        {
            newarray = new int[values.length-1];
            for (int i = 0; i < values.length; i++)
            {
                if (i < ((values.length-1)/2))
                {
                    newarray[i] = values[i];
                }
                 
                else if (i > ((values.length-1)/2))
                {
                    newarray[i-1] = values[i];
                }
            }
        }
        
        values = newarray;
    }
    
    public void evenToFront()
    {
       int[] temp = new int[values.length];
       for (int i = 0; i < values.length; i++)
       {
           temp[i] = values[i];
       }
       
       for (int i = 0; i < values.length; i++)
       {
           if ((temp[i] % 2) == 0)
           {
               for (int j = 0; j < i; j++)
               {
                   values[j+1] = temp[j];
               }
               
               values[0] = temp[i];
               
               for (int k = 0; k < values.length; k++)
               {
                   temp[k] = values[k];
               }
           }
       }
    }
}
