
public class ElementRemoval
{
    public static void main(String[] args)
    {
        int searchValue = 100;
        int[] values = { 80, 90, 100, 120, 110 };
        int pos = 0;
        boolean found = false;
        while ( pos < values.length && !found )
        {
            if ( values[pos] == searchValue )
            {
                found = true;
            }
            else
            {
                pos++;
            }
        }

        if ( found )
        {
            System.out.println("Found at position: " + pos);
        }
        else
        {
            System.out.println("Not found");
        }

    }

}
