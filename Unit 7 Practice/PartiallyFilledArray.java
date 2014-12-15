
public class PartiallyFilledArray
{
    private int[] values;
    private int currentSize;
    
    public PartiallyFilledArray()
    {
        this.values = new int[10];
        this.currentSize = 0;
    }

    public String toString()
    {
        String str = "[";
        
        for (int i = 0; i < this.currentSize; i++)
        {
            if (i > 0)
            {
                str += ", ";
            }
            str += this.values[i];
        }
        
        str += "]";
        return str;
    }
    
    public void fill(int num, int maxValue)
    {
        for (int i = 0; i < num; i++)
        {
            this.values[i] = (int)(Math.random() * maxValue);
            currentSize++;
        }
    }
    
    public void removeElementAtIndex(int index)
    {
        this.values[index] = this.values[currentSize - 1];
        currentSize--;
    }
    
    public void swapElements(int index1, int index2)
    {
        int value1 = this.values[index1];
        this.values[index1] = this.values[index2];
        this.values[index2] = value1;
    }
    
    public void insertElement(int val)
    {
        if (currentSize < this.values.length)
        {
           growArray();
        }
        
        this.values[currentSize] = val;
        currentSize++;
    }
    
    private void growArray()
    {
        int newArraySize = this.values.length * 2;
        int [] newArray = new int[newArraySize];
        
        for (int i = 0; i < this.values.length; i++)
        {
            newArray[i] = this.values[i];
        }
        
        this.values = newArray;
    }
}
